package com.geekbrains.controller;

import com.geekbrains.dto.ProductDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ProductController {
    @GetMapping("/product")
    String findAll(Model model);

    @PostMapping("/product")
    String save(@ModelAttribute ProductDto productDto);

    public List<ProductDto> findAll();

}
