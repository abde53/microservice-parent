package com.abde53.productservice.dto;

import com.abde53.productservice.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toModel(ProductDto productDto);
    ProductDto toDto(Product p);

    List<ProductDto> toDtos(List<Product> listP);
}
