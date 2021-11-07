package com.geekbrains.service;

import com.geekbrains.dto.ProductDto;
import com.geekbrains.model.Person;
import com.geekbrains.model.Product;
import com.geekbrains.model.repository.PersonRepository;
import com.geekbrains.model.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private static final String PERSON_ID = "14983a99-cc7a-4e49-a670-7d4145a7b38d";
    private final ProductRepository productRepository;
    private final PersonRepository personRepository;

    public ProductService(ProductRepository productRepository, PersonRepository personRepository){
        this.productRepository = productRepository;
        this.personRepository = personRepository;
    }

    public Flux<Product>  findAll(){
        return productRepository.findAll();
    }

    public Mono<Person> defindPerson(){
        return personRepository.findById(UUID.fromString(PERSON_ID));
    }

    public Mono<Product> save(Product product){
        return productRepository.save(product);
    }
}
