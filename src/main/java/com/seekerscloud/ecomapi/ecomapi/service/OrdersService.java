package com.seekerscloud.ecomapi.ecomapi.service;

import com.seekerscloud.ecomapi.ecomapi.dto.request.OrdersRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.OrdersResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedOrdersResponseDTO;

public interface OrdersService {
    public String createOrders(OrdersRequestDTO dto);
    public OrdersResponseDTO findOrders(String id) throws ClassNotFoundException;
    public String updateOrders(OrdersRequestDTO dto, String order_id) throws ClassNotFoundException;
    public String deleteOrders(String  order_id);
    public PaginatedOrdersResponseDTO findAllOrders(
            String searchText, int page, int size
    );
}
