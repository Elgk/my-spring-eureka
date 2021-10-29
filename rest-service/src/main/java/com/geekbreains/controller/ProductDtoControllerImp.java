package com.geekbreains.controller;

import com.geekbreains.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/get-product")
public class ProductDtoControllerImp  {
    private final ProductDtoController productDtoController;
    private RestTemplate restTemplate;
 //   private String address = "http://localhost:9872";


    public ProductDtoControllerImp(ProductDtoController productDtoController){
        this.productDtoController = productDtoController;
    }

    @Autowired
    private void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
       return new RestTemplate();
    }


    @GetMapping
    public String findAll(Model model){
        List<ProductDto> products = restTemplate.exchange( "http://model-service/findAll", HttpMethod.GET, new HttpEntity<>(new ProductDto()), new ParameterizedTypeReference<List<ProductDto>>() {}).getBody();
        model.addAttribute("products", products);
        return "product-view";
    }

    @PostMapping
    public String save(@ModelAttribute ProductDto product){
        productDtoController.save(product);
        return "redirect:/product-view";
    }


}
