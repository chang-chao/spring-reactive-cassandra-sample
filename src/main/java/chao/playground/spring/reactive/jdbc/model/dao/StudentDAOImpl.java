package chao.playground.spring.reactive.jdbc.model.dao;

import org.springframework.stereotype.Service;

import com.github.davidmoten.rx.jdbc.Database;

import chao.playground.spring.reactive.jdbc.model.Student;
import rx.Observable;

@Service
public class StudentDAOImpl implements StudentDAO {
  @Override
  public Observable<Student> getAllStudents() {
    Database db = Database.from("jdbc:mysql://localhost:3306/shopping", "root", "petclinic");

    Class<String> stringClass = String.class;
    return db.select("select id,name from student").getAs(Integer.class, stringClass)
        .map(empRow -> {
          Student student = new Student();
          student.setId(empRow._1());
          student.setName(String.valueOf(empRow._2()));
          return student;
        });
  }
}
