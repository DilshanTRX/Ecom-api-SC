package com.seekerscloud.ecomapi.ecomapi.util.mapper;

import com.seekerscloud.ecomapi.ecomapi.dto.OrdersDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.OrdersResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.Orders;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    Orders toOrders(OrdersDTO dto);
    OrdersResponseDTO toOrdersResponseDTO(Orders orders);
    List<OrdersResponseDTO> toOrdersResponseDTOList(List<Orders> list);
}
