package chao.playground.spring.reactive.web.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;

import chao.playground.spring.reactive.data.domain.Person;
import chao.playground.spring.reactive.repository.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/person")
@EnableAutoConfiguration
public class PersonController {

  @Autowired
  private PersonRepository personRepository;

  @RequestMapping(value = "/")
  public Flux<Person> list() {
    return personRepository.findAll();
  }

  @RequestMapping(value = "/add")
  public Mono<Person> add() {
    Person alice = new Person(UUIDs.timeBased(), "Alice");
    return personRepository.insert(alice);
  }

}
