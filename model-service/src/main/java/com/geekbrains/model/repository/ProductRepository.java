package com.geekbrains.model.repository;

import com.geekbrains.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


public interface ProductRepository extends CrudRepository<Product, UUID> {
    List<Product> findAll();
}
