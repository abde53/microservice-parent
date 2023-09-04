package com.abde53.orderservice.dto;

import com.abde53.orderservice.model.OrderLineItems;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {

    private String orderNumber;
    private List<OrderLineItemsResponse> orderLineItemsListResponse;
}