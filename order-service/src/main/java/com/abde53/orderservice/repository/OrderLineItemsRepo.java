package com.abde53.orderservice.repository;

import com.abde53.orderservice.model.OrderLineItems;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineItemsRepo  extends MongoRepository<OrderLineItems, String> {

}
