package chao.playground.spring.reactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.data.cassandra.config.java.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@SpringBootApplication
@EnableReactiveCassandraRepositories()
public class PlaygroundApplication extends AbstractReactiveCassandraConfiguration {

  @Autowired
  private CassandraProperties properties;

  public static void main(String[] args) {
    SpringApplication.run(PlaygroundApplication.class, args);
  }

  @Override
  protected String getKeyspaceName() {
    return properties.getKeyspaceName();
  }
}
