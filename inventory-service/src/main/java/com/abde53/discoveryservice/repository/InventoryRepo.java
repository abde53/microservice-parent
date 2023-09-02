package com.abde53.discoveryservice.repository;

import com.abde53.discoveryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Long> {

    public Inventory getInventoryBySkuCode(String skucode);
}
