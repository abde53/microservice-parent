package com.abde53.orderservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Document(collection = "order_line_items")
public class OrderLineItems {



    @Id
    private String id;

    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
