package chao.playground.spring.reactive.cassandra.data.domain;

import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Table
@Getter
@Setter
@AllArgsConstructor
public class Person {
  @PrimaryKey
  private UUID  id;

  private String name;
}
