package com.geekbreains.dto;

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

}
