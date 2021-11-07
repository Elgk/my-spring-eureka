package com.geekbreains.controller;

import com.geekbreains.dto.Product;
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
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/get-product")
public class ProductDtoControllerImp  {
    private final ProductDtoController productDtoController;
//    private RestTemplate restTemplate;

    private final String address = "http://localhost:9872";
    WebClient webClient = WebClient.builder().build();



    public ProductDtoControllerImp(ProductDtoController productDtoController){
        this.productDtoController = productDtoController;
    }

//    @Autowired
//    private void setRestTemplate(RestTemplate restTemplate){
//        this.restTemplate = restTemplate;
//    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//       return new RestTemplate();
//    }


    @GetMapping
    public String findAll(Model model){
    //    List<ProductDto> products = restTemplate.exchange( "http://model-service/findAll", HttpMethod.GET, new HttpEntity<>(new ProductDto()), new ParameterizedTypeReference<List<ProductDto>>() {}).getBody();
        Flux<Product> productFlux = webClient.get()
                .uri(address + "/findAll")
                .retrieve()
                .bodyToFlux(Product.class);
        List<Product> list = new ArrayList<>();
        productFlux.subscribe(product -> list.add(product));
        model.addAttribute("products", list);
        return "product-view";
    }

    @PostMapping
    public String save(@ModelAttribute Product product){
       webClient.post()
                .uri(address + "/product")
                .bodyValue(product)
                .retrieve()
                .bodyToMono(Product.class);
     //   productDtoController.save(product);
        return "redirect:/product-view";
    }


}
