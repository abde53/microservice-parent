package com.abde53.discoveryservice.dto;

import com.abde53.discoveryservice.model.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InventoryMapper {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    Inventory toModel(InventoryDto inventoryDto);

    List<Inventory> toModels(List<InventoryDto> inventoryDtos);

    InventoryDto toDto(Inventory inventory);

    List<InventoryDto> toDtos(List<Inventory> inventories);


}
