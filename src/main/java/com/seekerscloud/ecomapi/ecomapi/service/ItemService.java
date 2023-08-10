package com.seekerscloud.ecomapi.ecomapi.service;


import com.seekerscloud.ecomapi.ecomapi.dto.request.ItemRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.ItemResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedItemResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.Item;

public interface ItemService {
    public String createItem(ItemRequestDTO dto);
    public ItemResponseDTO findItem(int code) throws ClassNotFoundException;
    public String updateItem(ItemRequestDTO dto, int id) throws ClassNotFoundException;
    public String deleteItem(int code);
    public PaginatedItemResponseDTO findAllItem(
            String searchText, int page, int size
    );
}
