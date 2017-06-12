package chao.playground.spring.reactive.webexchange;

import java.time.Instant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.adapter.DefaultServerWebExchange;

import chao.playground.spring.reactive.web.home.BootStarter;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/webexchange")
public class TestWebExchangeController {
	private Instant lastModified = Instant.now();

	@RequestMapping(value = "/")
	public Mono<BootStarter> starter(DefaultServerWebExchange exchange) {
		boolean notModified = exchange.checkNotModified(lastModified);
		if (notModified) {
			return null;
		}
		return Mono.just(new BootStarter("spring-boot-starter-web-reactive", "Spring Boot Web Reactive"));
	}

	@RequestMapping(value = "/update")
	public void update() {
		lastModified = Instant.now();
	}
}
