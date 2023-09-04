package com.abde53.orderservice.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InventoryResponse {

    private String skuCode;
    private Boolean available;
}
