package com.geekbrains.controller;

import com.geekbrains.dto.ProductDto;
import com.geekbrains.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductControllerImp implements ProductController{
    private final ProductService productService;

    public ProductControllerImp(ProductService productService){
        this.productService = productService;
    }


    @Override
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @Override
    public String save(ProductDto productDto) {
        productService.save(productDto);
        return "redirect:/product";
    }

    @Override
    public List<ProductDto> findAll() {
        return productService.findAll();
    }
}
