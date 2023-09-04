package com.abde53.orderservice.service;

import com.abde53.orderservice.dto.*;
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
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;
    private final OrderLineItemsRepo orderLineItemsRepo;
    private final InventoryInterface inventoryInterface;

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

    public OrderResponse placeOrder(Order o)
    {
        log.info("Placing order : {} ",o);
        List<InventoryDto> inventoryDtos = OrderMapper.INSTANCE.toInventoryDtos(o.getOrderLineItemsList());
        List<InventoryResponse> inventoryResponses = this.inventoryInterface.areInStock(inventoryDtos);
        OrderResponse orderResponse = OrderMapper.INSTANCE.toResponse(o);

        if(orderResponse != null)
        {
            orderResponse.setOrderLineItemsListResponse(
                    OrderMapper.INSTANCE.toLineResponse(o.getOrderLineItemsList())
            );
            orderResponse.getOrderLineItemsListResponse().forEach(orderLineItemsResponse -> {
                Optional<InventoryResponse> matchingInventoryResponse = inventoryResponses.stream()
                        .filter(inventoryResponse -> inventoryResponse.getSkuCode().equals(orderLineItemsResponse.getSkuCode()))
                        .findFirst();

                if (matchingInventoryResponse.isPresent()) {
                    orderLineItemsResponse.setAvailable(matchingInventoryResponse.get().getAvailable());
                } else {
                    // Handle the case where no matching inventory response was found.
                    // You can set a default value or throw an exception depending on your requirements.
                }
            });
        }


        return orderResponse;
    }

    public List<InventoryDto> getInventories()
    {
        log.info("Getting all inventories from Order service");
        List<InventoryDto> inventoryDtos = this.inventoryInterface.getAllInventory();
        return inventoryDtos;
    }
}
