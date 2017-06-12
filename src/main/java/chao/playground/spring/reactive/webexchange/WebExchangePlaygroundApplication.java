package chao.playground.spring.reactive.webexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
public class WebExchangePlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebExchangePlaygroundApplication.class, args);
	}

	/**
	 * NOT supported in webflux
	 */
	@Bean
	public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
		return new ShallowEtagHeaderFilter();
	}
}
