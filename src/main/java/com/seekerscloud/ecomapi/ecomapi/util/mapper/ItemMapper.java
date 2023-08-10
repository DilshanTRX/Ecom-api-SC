package com.seekerscloud.ecomapi.ecomapi.util.mapper;

import com.seekerscloud.ecomapi.ecomapi.dto.ItemDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.ItemResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    Item toItem(ItemDTO dto);
     ItemResponseDTO toItemResponseDTO(Item item);
    List<ItemResponseDTO> toItemResponseDTOList(List<Item> list);
}
