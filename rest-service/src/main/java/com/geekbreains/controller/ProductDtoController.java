package com.geekbreains.controller;

import com.geekbreains.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("model-sevice")
public interface ProductDtoController {
    @GetMapping("/product")
    String findAll(Model model);

    @PostMapping("/product")
    String save(@ModelAttribute ProductDto productDto);

    @GetMapping()
    List<ProductDto> findAll();

}
