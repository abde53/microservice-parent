package com.abde53.discoveryservice.service;

import com.abde53.discoveryservice.exception.NoInventoryFoundException;
import com.abde53.discoveryservice.model.Inventory;
import com.abde53.discoveryservice.repository.InventoryRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepo inventoryRepo;

    public Inventory save(Inventory inventory)
    {
        log.info("saving new inventory : {}", inventory);
        return this.inventoryRepo.save(inventory);
    }

    public List<Inventory> getAll()
    {
        log.info("Getting all inventories");
        return this.inventoryRepo.findAll();
    }



    public boolean isInStock(String skuCode, Integer quantity)
    {
        log.info("Getting inventory of : {}", skuCode);
        Inventory inventory = this.inventoryRepo.getInventoryBySkuCode(skuCode);
        if(inventory == null)
        {
            throw new NoInventoryFoundException("No Inventory found");
        }
        if(quantity <= inventory.getQuantity())
            return true;
        else
            return false;

    }
}
