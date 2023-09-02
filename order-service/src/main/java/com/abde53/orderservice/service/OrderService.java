package com.abde53.orderservice.service;

import com.abde53.orderservice.dto.InventoryDto;
import com.abde53.orderservice.feign.InventoryInterface;
import com.abde53.orderservice.model.Order;
import com.abde53.orderservice.model.OrderLineItems;
import com.abde53.orderservice.repository.OrderLineItemsRepo;
import com.abde53.orderservice.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final OrderLineItemsRepo orderLineItemsRepo;
    @Autowired
     InventoryInterface inventoryInterface;

    public List<Order> findAll()
    {
        log.info("Get all orders");
        return this.orderRepo.findAll();
    }

    public Order addOrder(Order o)
    {
        log.info("Adding new order : {}", o);
        orderLineItemsRepo.saveAll(o.getOrderLineItemsList());
        return this.orderRepo.save(o);
    }

    public void placeOrder(Order o)
    {
        List<InventoryDto> inventoryDtos = this.inventoryInterface.getAllInventory();
        log.info(inventoryDtos.toString());
    }
}
