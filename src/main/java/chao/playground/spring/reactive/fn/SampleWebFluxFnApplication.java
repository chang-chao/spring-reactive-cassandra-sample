package chao.playground.spring.reactive.fn;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.EntityResponse;
import org.springframework.web.reactive.function.server.RouterFunction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { CassandraDataAutoConfiguration.class })
public class SampleWebFluxFnApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleWebFluxFnApplication.class);
	}

	@Bean
	public RouterFunction<EntityResponse<Flux<Person>>> listFunction(PersonHandler personHandler) {
		return route(GET("/fn/person").and(accept(APPLICATION_JSON)), personHandler::listPeople);
	}

	@Bean
	public RouterFunction<EntityResponse<Mono<Person>>> getFunction(PersonHandler personHandler) {
		return route(GET("/fn/person/{id}").and(accept(APPLICATION_JSON)), personHandler::getPerson);
	}

	// @Bean
	// public RouterFunction<ServerResponse> personFunction(PersonHandler
	// personHandler) {
	// return nest(path("/fn/person"),
	// nest(accept(APPLICATION_JSON),
	// route(GET("/{id}"),
	// personHandler::getPerson).andRoute(method(HttpMethod.GET),
	// personHandler::listPeople)).andRoute(POST("/").and(contentType(APPLICATION_JSON)),
	// personHandler::createPerson));
	// }
	//
	// @Bean
	// public RouterFunction<ServerResponse> otherFunction(PersonHandler
	// personHandler) {
	// return route(GET("/fn/helloworld"), request ->
	// ServerResponse.ok().body(fromObject("Hello World"))).filter((request,
	// next) -> {
	// Mono <ServerResponse> response = next.handle(request).flatMap(res -> {
	//
	// Mono<Integer> intMono = res.entity()
	// .map(Integer::parseInt);
	// return EntityResponse.fromPublisher(intMono, Integer.class).build();
	//
	// });
	// String newBody = response.body().toUpperCase();
	// return Response.from(response).body(fromObject(newBody));
	// });
	// }
}