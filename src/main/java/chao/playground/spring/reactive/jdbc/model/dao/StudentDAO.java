package chao.playground.spring.reactive.jdbc.model.dao;

import chao.playground.spring.reactive.jdbc.model.Student;
import rx.Observable;

public interface StudentDAO {
  public Observable<Student> getAllStudents();

  public Integer save(Student student);
}
