package com.geekbrains.model.repository;

import com.geekbrains.model.Person;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PersonRepository extends R2dbcRepository<Person, UUID> {

}
