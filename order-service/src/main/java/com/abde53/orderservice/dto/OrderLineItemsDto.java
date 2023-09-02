package com.abde53.orderservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Data
public class OrderLineItemsDto {
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
