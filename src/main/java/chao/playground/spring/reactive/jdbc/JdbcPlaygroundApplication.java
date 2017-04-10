package chao.playground.spring.reactive.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;

@SpringBootApplication(exclude = CassandraDataAutoConfiguration.class)
//see:https://github.com/nmarasoiu/Spring-JDBC
//https://www.infoq.com/articles/Refactoring-Reactive-JDBC
public class JdbcPlaygroundApplication {
  public static void main(String[] args) {
    SpringApplication.run(JdbcPlaygroundApplication.class, args);
  }
}
