package com.seekerscloud.ecomapi.ecomapi.util.mapper;

import com.seekerscloud.ecomapi.ecomapi.dto.CustomerDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.CustomerResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toCustomer(CustomerDTO dto);
    CustomerResponseDTO toCustomerResponseDTO(Customer customer);
    List<CustomerResponseDTO> toCustomerResponseDTOList(List<Customer> list);
}
