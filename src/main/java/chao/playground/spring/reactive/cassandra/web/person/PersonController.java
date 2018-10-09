package chao.playground.spring.reactive.cassandra.web.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;

import chao.playground.spring.reactive.cassandra.data.domain.Person;
import chao.playground.spring.reactive.cassandra.repository.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
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

	@GetMapping(path = "/sse", produces = "text/event-stream")
	public Flux<Person> getPersons() {
		return this.personRepository.findAll();
	}
}
