package com.abde53.productservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private String name;
    private String description;
    private BigDecimal price;
}
