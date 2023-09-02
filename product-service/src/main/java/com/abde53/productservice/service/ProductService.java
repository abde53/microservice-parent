package com.abde53.productservice.service;

import com.abde53.productservice.dto.ProductDto;
import com.abde53.productservice.model.Product;
import com.abde53.productservice.repository.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public Product save(Product product)
    {
        return this.productRepo.save(product);
    }

    public List<Product> getAllProduct()
    {
        return this.productRepo.findAll();
    }
}
