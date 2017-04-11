package chao.playground.spring.reactive.jdbc.web;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chao.playground.spring.reactive.jdbc.model.Student;
import chao.playground.spring.reactive.jdbc.model.dao.StudentDAO;
import rx.Observable;

@RestController
@RequestMapping(value = "/jdbc/student")
public class StudentController {
  @Autowired
  private StudentDAO studentDao;

  @RequestMapping(value = "/")
  public Observable<Student> list() {
    return studentDao.getAllStudents();
  }

  @RequestMapping(value = "/save")
  public Observable<Integer> save() {
    Student student = new Student();
    student.setName("randomName:" + new Random().nextDouble());
    return studentDao.save(student);
  }

}
