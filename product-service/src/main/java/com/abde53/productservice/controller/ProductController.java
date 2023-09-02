package com.abde53.productservice.controller;

import com.abde53.productservice.dto.ProductDto;
import com.abde53.productservice.dto.ProductMapper;
import com.abde53.productservice.model.Product;
import com.abde53.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "sayHello")
    public String sayHello()
    {
        return "Hello";
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "addProduct")
    public Product addProduct(@RequestBody ProductDto productDto)
    {
        Product p = ProductMapper.INSTANCE.toModel(productDto);
        log.info("Adding new Product : {}", p);
        return this.productService.save(p);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "getAllProduct")
    public List<ProductDto> getAllProduct()
    {
        List<ProductDto> dtos = ProductMapper.INSTANCE.toDtos(this.productService.getAllProduct());
        return dtos;
    }
}
