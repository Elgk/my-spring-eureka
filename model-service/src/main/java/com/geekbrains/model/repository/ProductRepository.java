package com.geekbrains.model.repository;

import com.geekbrains.model.Product;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends R2dbcRepository<Product, UUID> {
   Flux<Product> findAll();
}
