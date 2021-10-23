package com.geekbreains.controller;

import com.geekbreains.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/get-product")
public class ProductDtoControllerImp  {
    private final ProductDtoController productDtoController;

    public ProductDtoControllerImp(ProductDtoController productDtoController){
        this.productDtoController = productDtoController;
    }

    @GetMapping
    public String findAll(Model model){
        List<ProductDto> products = productDtoController.findAll();
        model.addAttribute("products", products);
        return "product-view";
    }

    @PostMapping
    public String save(@ModelAttribute ProductDto product){
        productDtoController.save(product);
        return "redirect:/product-view";
    }
}
