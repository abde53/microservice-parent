package com.abde53.orderservice.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryDto {
    private String skuCode;
    private Integer quantity;
}
