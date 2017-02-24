package chao.playground.spring.reactive.web.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HomeController {

  @RequestMapping(value = "/")
  public Mono<BootStarter> starter() {
    return Mono.just(new BootStarter("spring-boot-starter-web-reactive", "Spring Boot Web Reactive"));
  }

  @RequestMapping(value = "/starters")
  public Flux<BootStarter> starters() {
    return Flux.just(new BootStarter("spring-boot-starter-web-reactive", "Spring Boot Web Reactive"),
        new BootStarter("spring-boot-starter-web", "Spring Boot Web"),
        new BootStarter("spring-boot-starter-websocket", "Spring Boot Websocket"));
  }

  @RequestMapping(value = "/custom-arg")
  public Mono<String> customArg(CustomArgument custom) {
    return Mono.just(custom.getCustom());
  }
}
