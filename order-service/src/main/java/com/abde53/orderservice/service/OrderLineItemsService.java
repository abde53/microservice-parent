package com.abde53.orderservice.service;

import com.abde53.orderservice.repository.OrderLineItemsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.abde53.orderservice.model.OrderLineItems;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderLineItemsService {

    private final OrderLineItemsRepo orderLineItemsRepo;

    public List<OrderLineItems> findAll()
    {
        log.info("Get All Order Line Items");
        return this.orderLineItemsRepo.findAll();
    }

    public OrderLineItems addOrderLineItems(OrderLineItems o)
    {
        log.info("Adding new Order Line Items : {}", o);
        return this.orderLineItemsRepo.save(o);
    }
}
