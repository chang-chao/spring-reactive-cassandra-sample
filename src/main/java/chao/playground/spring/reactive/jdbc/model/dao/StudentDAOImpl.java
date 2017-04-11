package chao.playground.spring.reactive.jdbc.model.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.davidmoten.rx.jdbc.Database;

import chao.playground.spring.reactive.jdbc.model.Student;
import rx.Observable;

@Service
public class StudentDAOImpl implements StudentDAO {

  private Database db;

  @Autowired
  public void setDataSource(DataSource ds) {
    this.db = Database.fromDataSource(ds).asynchronous();
  }

  @Override
  public Observable<Student> getAllStudents() {
    return db.select("select id,name from student").getAs(Integer.class, String.class)
        .map(empRow -> {
          Student student = new Student();
          student.setId(empRow._1());
          student.setName(String.valueOf(empRow._2()));
          return student;
        });
  }

  @Override
  public Observable<Integer> save(Student student) {
  //  Observable<Boolean> begin = db.beginTransaction();
    Observable<Integer> id = db.update("insert into student(name) values(?)")
        //.dependsOn(begin)
        .parameters(student.getName()).returnGeneratedKeys().getAs(Integer.class);
//    Observable<Boolean> commit = db.commit(id).exists(r->r);
    return id;
  }
}
