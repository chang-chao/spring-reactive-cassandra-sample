package chao.playground.spring.reactive.fn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.EntityResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {
	@Autowired
	private PersonRepository repository;

	public Mono<EntityResponse<Mono<Person>>> getPerson(ServerRequest request) {
		int personId = Integer.valueOf(request.pathVariable("id"));
		Mono<Person> personMono = this.repository.getPerson(personId);
		return EntityResponse.fromPublisher(personMono, Person.class).build();
	}

	public Mono<ServerResponse> createPerson(ServerRequest request) {
		Mono<Person> person = request.bodyToMono(Person.class);
		return ServerResponse.ok().build(this.repository.savePerson(person));
	}

	public Mono<EntityResponse<Flux<Person>>> listPeople(ServerRequest request) {
		Flux<Person> people = this.repository.allPeople();
		return EntityResponse.fromPublisher(people, Person.class).build();
	}
}
