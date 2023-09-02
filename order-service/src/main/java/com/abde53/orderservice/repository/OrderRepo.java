package com.abde53.orderservice.repository;

import com.abde53.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo  extends MongoRepository<Order, String> {


}
