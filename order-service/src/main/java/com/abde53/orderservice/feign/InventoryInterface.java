package com.abde53.orderservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.abde53.orderservice.dto.InventoryDto;
import java.util.List;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryInterface {

    @GetMapping(value = "/isInStock")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(String skuCode, Integer quantity);

    @GetMapping(value = "/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryDto> getAllInventory();
}
