package chao.playground.spring.reactive.fn;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {
	@Autowired
	private  PersonRepository repository;
	
	public Mono<ServerResponse> getPerson(ServerRequest request) {
		int personId = Integer.valueOf(request.pathVariable("id"));
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		Mono<Person> personMono = this.repository.getPerson(personId);
		return personMono
				.flatMap(person -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(person)))
				.switchIfEmpty(notFound);
	}


	public Mono<ServerResponse> createPerson(ServerRequest request) {
		Mono<Person> person = request.bodyToMono(Person.class);
		return ServerResponse.ok().build(this.repository.savePerson(person));
	}

	public Mono<ServerResponse> listPeople(ServerRequest request) {
		Flux<Person> people = this.repository.allPeople();
		return ServerResponse.ok().contentType(APPLICATION_JSON).body(people, Person.class);
}
}
