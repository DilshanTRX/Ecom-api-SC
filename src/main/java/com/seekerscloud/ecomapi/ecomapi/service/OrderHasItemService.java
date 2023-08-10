package com.seekerscloud.ecomapi.ecomapi.service;


import com.seekerscloud.ecomapi.ecomapi.dto.request.OrderHasItemRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.OrderHasItemResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedOrderHasItemResponseDTO;

public interface OrderHasItemService {
    public String createOrderHasItem(OrderHasItemRequestDTO dto);

    public OrderHasItemResponseDTO findOrderHasItem(String order_order_id) throws ClassNotFoundException;

    public String updateOrderHasItem(OrderHasItemRequestDTO dto, String order_order_id) throws ClassNotFoundException;
    String deleteOrderHasItem(String orderOrderId, int itemCode);
    public PaginatedOrderHasItemResponseDTO findAllOrderHasItem(
            String searchText, int page, int size
    );
}
