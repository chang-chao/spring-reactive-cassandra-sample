package chao.playground.spring.reactive.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@SpringBootApplication
@EnableReactiveCassandraRepositories
public class CassandraPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(CassandraPlaygroundApplication.class, args);
	}

}
