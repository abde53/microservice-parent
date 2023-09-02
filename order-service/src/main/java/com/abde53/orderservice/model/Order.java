package com.abde53.orderservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Document(collection = "order")
public class Order {


    @Id
    private String id;
    private String orderNumber;

    @DBRef(lazy = true)
    private List<OrderLineItems> orderLineItemsList;
}
