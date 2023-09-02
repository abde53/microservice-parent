package com.abde53.orderservice.dto;

import com.abde53.orderservice.model.Order;
import com.abde53.orderservice.model.OrderLineItems;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toModel(OrderDto orderDto);
}
