package com.abde53.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLineItemsResponse {

    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
    private Boolean available;
}
