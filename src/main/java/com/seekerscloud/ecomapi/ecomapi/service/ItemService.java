package com.seekerscloud.ecomapi.ecomapi.service;


import com.seekerscloud.ecomapi.ecomapi.dto.request.ItemRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.CustomerResponseDTO;

public interface ItemService {
    public CustomerResponseDTO createProduct(ItemRequestDTO dto);
}
