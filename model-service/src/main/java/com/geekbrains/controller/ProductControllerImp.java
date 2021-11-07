package com.geekbrains.controller;

import com.geekbrains.dto.ProductDto;
import com.geekbrains.model.Product;
import com.geekbrains.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
//@RequestMapping("/product")
public class ProductControllerImp implements ProductController{
    private final ProductService productService;

    public ProductControllerImp(ProductService productService){
        this.productService = productService;
    }


    @Override
    public String viewFindAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @Override
    public String save(Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    public Flux<Product> findAll() {
        return productService.findAll();
    }
}
