package com.geekbrains.dto;

import com.geekbrains.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private UUID id;
    private String name;
    private BigDecimal price;
    private int count;
    private String vendorCode;

    public static ProductDto valueOf(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCount(productDto.getCount());
        productDto.setVendorCode(productDto.getVendorCode());
        return productDto;
    }

    public Product mapToProduct(){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setCount(count);
        product.setVendorCode(vendorCode);
        return product;
    }

}
