package com.geejbrains.unit;

import com.geekbrains.dto.ProductDto;
import com.geekbrains.model.Product;
import com.geekbrains.model.repository.ProductRepository;
import com.geekbrains.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@SpringBootTest(classes = ProductService.class)
public class ProductApplicationTest {
    private static Product product;

    @Autowired
    private  ProductService productService;

    @MockBean
    private ProductRepository productRepository;

   @BeforeAll
    public static void initProduct() {
        product = new Product();
        product.setId(UUID.randomUUID());
        product.setCount(1);
        product.setPrice(BigDecimal.TEN);
        product.setVendorCode("111");
        product.setName("Milk");
    }

    @Test
    public void  findAllSuccess(){
        Mockito.doReturn(Collections.emptyList()).when(productRepository.findAll());
        Mockito.when(productRepository.findAll()).thenReturn(Collections.emptyList());
        List<ProductDto> actual = productService.findAll();
        Assertions.assertThat(actual).isNotEmpty();

    }

    @Test
    public void findAllTest(){
        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setCount(1);
        product1.setPrice(BigDecimal.TEN);
        product1.setVendorCode("222");
        product1.setName("Butter");

        Mockito.doReturn(List.of(product, product1))
                .when(productService)
                .findAll();

        List<ProductDto> products = productService.findAll();
        Assertions.assertEquals(2, products.size());
    }

}
