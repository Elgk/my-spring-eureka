package com.geekbrains.service;

import com.geekbrains.dto.ProductDto;
import com.geekbrains.model.Person;
import com.geekbrains.model.Product;
import com.geekbrains.model.repository.PersonRepository;
import com.geekbrains.model.repository.ProductRepository;
import org.springframework.stereotype.Service;

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

    public List<ProductDto> findAll(){
        return productRepository.findAll().stream()
                .map(ProductDto::valueOf)
                .collect(Collectors.toList());
    }

    public Person defindPerson(){
        return personRepository.findById(UUID.fromString(PERSON_ID)).get();
    }

    public Product save(ProductDto productDto){
        Product product = productDto.mapToProduct();
        product.setCreatedBy(defindPerson());
        return productRepository.save(product);
    }
}
