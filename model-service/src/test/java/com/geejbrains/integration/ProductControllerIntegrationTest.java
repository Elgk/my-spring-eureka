package com.geejbrains.integration;

import com.geekbrains.dto.ProductDto;
import com.geekbrains.model.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIntegrationTest {

    private static final String BASE_URL = "/product";

    @Autowired
    private ProductRepository productRepository;

    @LocalServerPort
    private String port;

    @Autowired
    private TestRestTemplate testTemplate;

    @AfterAll
    public void  clearData(){
        productRepository.deleteAll();
    }

    @Test
    public void findByIdSuccess(){
        ProductDto product = new ProductDto();
        product.setId(UUID.randomUUID());
        product.setCount(1);
        product.setPrice(BigDecimal.TEN);
        product.setVendorCode("111");
        product.setName("test");
        ProductDto savedProduct = productRepository.save(product);
        ResponseEntity<ProductDto> actual = testTemplate.getForEntity("http://localhost:" + port + BASE_URL + "/" +savedProduct.getId(), ProductDto.class);
        Assertions.assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(actual.getBody()).isNotNull();
    }
}
