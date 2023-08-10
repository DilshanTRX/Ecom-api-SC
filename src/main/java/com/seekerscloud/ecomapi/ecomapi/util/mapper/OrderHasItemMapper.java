package com.seekerscloud.ecomapi.ecomapi.util.mapper;

import com.seekerscloud.ecomapi.ecomapi.dto.OrderHasItemDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.OrderHasItemResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.OrderHasItem;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface OrderHasItemMapper {
    OrderHasItem toOrderHasItem(OrderHasItemDTO dto);
    OrderHasItemResponseDTO toOrderHasItemResponseDTO(OrderHasItem orderhasitem);
    List<OrderHasItemResponseDTO> toOrderHasItemResponseDTOList(List<OrderHasItem> list);
}
