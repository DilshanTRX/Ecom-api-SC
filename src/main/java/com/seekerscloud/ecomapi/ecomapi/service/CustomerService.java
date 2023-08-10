package com.seekerscloud.ecomapi.ecomapi.service;

import com.seekerscloud.ecomapi.ecomapi.dto.request.CustomerRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.CustomerResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedCustomerResponseDTO;

public interface CustomerService {
    public String createCustomer(CustomerRequestDTO dto);
    public CustomerResponseDTO findCustomer(String id) throws ClassNotFoundException;
    public String updateCustomer(CustomerRequestDTO dto, String id) throws ClassNotFoundException;
    public String deleteCustomer(String id);
    public PaginatedCustomerResponseDTO findAllCustomer(
            String searchText, int page, int size
    );
}
