package chao.playground.spring.reactive.fn;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository {
	Mono<Person> getPerson(int id);

	Flux<Person> allPeople();

	Mono<Void> savePerson(Mono<Person> person);
}
