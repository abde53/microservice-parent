package com.abde53.orderservice.dto;

import com.abde53.orderservice.model.OrderLineItems;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderLineItemsMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderLineItems toModel(OrderLineItemsDto orderLineItemsDto);

    List<InventoryDto> toDtos(List<OrderLineItems> orderLineItems);


}
