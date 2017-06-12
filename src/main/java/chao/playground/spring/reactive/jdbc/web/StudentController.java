package chao.playground.spring.reactive.jdbc.web;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chao.playground.spring.reactive.jdbc.model.Student;
import chao.playground.spring.reactive.jdbc.model.dao.StudentDAO;
import lombok.extern.apachecommons.CommonsLog;
import rx.Observable;

@RestController
@RequestMapping(value = "/jdbc/student")
@CommonsLog
public class StudentController {
  @Autowired
  private StudentDAO studentDao;

  @RequestMapping(value = "/")
  public Observable<Student> list() {
    log.debug("list start");
    Observable<Student> list = studentDao.getAllStudents();
    log.debug("list end");
    return list;
  }

  @RequestMapping(value = "/save")
  public Observable<Integer> save() {
    log.debug("save start");
    Student student = new Student();
    student.setName("randomName:" + new Random().nextDouble());
    Observable<Integer> studentId = studentDao.save(student);
    log.debug("save end");
    return studentId;
  }

}
