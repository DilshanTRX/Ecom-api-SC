package com.seekerscloud.ecomapi.ecomapi.service.impl;

import com.seekerscloud.ecomapi.ecomapi.dto.CustomerDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.request.CustomerRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.CustomerResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedCustomerResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.Customer;
import com.seekerscloud.ecomapi.ecomapi.repo.CustomerRepo;
import com.seekerscloud.ecomapi.ecomapi.service.CustomerService;
import com.seekerscloud.ecomapi.ecomapi.util.Generator;
import com.seekerscloud.ecomapi.ecomapi.util.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@EnableAutoConfiguration
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;



    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private Generator generator;

    @Override
    public String createCustomer(CustomerRequestDTO dto) {
        String generatedId = generator.generateId(5,12);
        Customer customer= new Customer(generatedId,dto.getName(), dto.getAddress(), dto.getSalary(),null);
        CustomerDTO sDto = new CustomerDTO();
        return  customerRepo.save(customer).getId()+" Saved";

    }

    @Override
    public CustomerResponseDTO findCustomer(String id) throws ClassNotFoundException {
        Optional<Customer> byId =customerRepo.findById(id);
        if(byId.isPresent()){
            return customerMapper.toCustomerResponseDTO(byId.get());
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String updateCustomer(CustomerRequestDTO dto, String id) throws ClassNotFoundException {
        Optional<Customer> byId = customerRepo.findById(id);

        if(byId.isPresent()) {

            byId.get().setName(dto.getName());
            byId.get().setAddress(dto.getAddress());
            byId.get().setSalary(dto.getSalary());
            customerRepo.save(byId.get());
            return byId.get().getName() + " was updated!";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deleteCustomer(String id) {

        customerRepo.deleteById(id);
        return id+ "was deleted";
    }

    @Override
    public PaginatedCustomerResponseDTO findAllCustomer(String searchText, int page, int size) {

        return new PaginatedCustomerResponseDTO(
                customerRepo.countCustomer(searchText),
                customerMapper.toCustomerResponseDTOList(customerRepo.searchCustomer(
                        searchText, PageRequest.of(page, size)
                ))
        );
    }
}
