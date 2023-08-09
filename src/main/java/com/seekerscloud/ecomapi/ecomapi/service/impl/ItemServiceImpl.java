package com.seekerscloud.ecomapi.ecomapi.service.impl;

import com.seekerscloud.ecomapi.ecomapi.dto.request.ItemRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.CustomerResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.repo.ItemRepo;
import com.seekerscloud.ecomapi.ecomapi.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class ItemServiceImpl implements ItemService {
   private final ItemRepo productRepo;
   @Autowired
    public ItemServiceImpl(ItemRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public CustomerResponseDTO createProduct(ItemRequestDTO dto){

//       productRepo.save();
        return null;
    }
}
