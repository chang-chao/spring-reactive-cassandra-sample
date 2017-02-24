package chao.playground.spring.reactive.data.domain;

import java.util.UUID;

import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

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
