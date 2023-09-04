package com.abde53.discoveryservice.controller;

import com.abde53.discoveryservice.dto.InventoryDto;
import com.abde53.discoveryservice.dto.InventoryMapper;
import com.abde53.discoveryservice.dto.InventoryResponse;
import com.abde53.discoveryservice.model.Inventory;
import com.abde53.discoveryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@Slf4j
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping(value = "/isInStock")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock( @RequestBody InventoryDto inventoryDto)
    {
        log.info("Checking if {} is in stock", inventoryDto);
        Inventory inventory = InventoryMapper.INSTANCE.toModel(inventoryDto);
        boolean isIn = this.inventoryService.isInStock(inventory);
        return isIn;
    }

    @PostMapping(value = "areInStock")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> areInStock(@RequestBody  List<InventoryDto> inventoryDtos)
    {
        List<Inventory> inventories = InventoryMapper.INSTANCE.toModels(inventoryDtos);
        List<InventoryResponse> inventoryResponses = new ArrayList<>();
        inventories.stream()
                .forEach(inventory -> {
                    inventoryResponses.add(
                            new InventoryResponse(
                                    inventory.getSkuCode(),
                                    this.inventoryService.isInStock(inventory)));
                });
        return inventoryResponses;
    }

    @GetMapping(value = "/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryDto> getAllInventory()
    {
        log.info("Getting all inventory");
        List<InventoryDto> inventoryDtos = InventoryMapper.INSTANCE.toDtos(this.inventoryService.getAll());
        return inventoryDtos;
    }

    @PostMapping(value = "/addInventory")
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory addInventory(@RequestBody InventoryDto inventoryDto)
    {
        log.info("add inventory");
        Inventory inventory = InventoryMapper.INSTANCE.toModel(inventoryDto);
        Inventory ret = this.inventoryService.save(inventory);
        return ret;
    }
}
