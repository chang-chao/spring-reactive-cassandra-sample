package chao.playground.spring.reactive.cassandra.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import chao.playground.spring.reactive.cassandra.data.domain.Person;

public interface PersonRepository extends ReactiveCassandraRepository<Person, String> {

}
