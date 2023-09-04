package com.abde53.orderservice.controller;

import com.abde53.orderservice.dto.*;
import com.abde53.orderservice.model.Order;
import com.abde53.orderservice.model.OrderLineItems;
import com.abde53.orderservice.service.OrderLineItemsService;
import com.abde53.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/v1/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final OrderLineItemsService orderLineItemsService;

    @PostMapping("placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse placeOrder(@RequestBody OrderDto orderRequest) {
        log.info("Placing Order");
        Order o = OrderMapper.INSTANCE.toModel(orderRequest);
        OrderResponse orderResponse = this.orderService.placeOrder(o);
       // o.setOrderLineItemsList(orderRequest.getOrderLineItemsList());
        return orderResponse;
    }

    @GetMapping("getAllOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryDto> getAllInventories()
    {
        log.info("Getting all InventoryDto");
        return this.orderService.getInventories();
    }

}
