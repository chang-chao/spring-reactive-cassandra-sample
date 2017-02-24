package chao.playground.spring.reactive.repository;

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import chao.playground.spring.reactive.data.domain.Person;

public interface PersonRepository extends ReactiveCassandraRepository<Person, String> {

}
