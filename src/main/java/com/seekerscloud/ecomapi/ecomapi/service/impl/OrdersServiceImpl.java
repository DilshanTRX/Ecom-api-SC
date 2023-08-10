package com.seekerscloud.ecomapi.ecomapi.service.impl;

import com.seekerscloud.ecomapi.ecomapi.dto.CustomerDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.request.OrdersRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.OrdersResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedOrdersResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.Orders;
import com.seekerscloud.ecomapi.ecomapi.repo.CustomerRepo;
import com.seekerscloud.ecomapi.ecomapi.repo.OrdersRepo;
import com.seekerscloud.ecomapi.ecomapi.repo.UserRepo;
import com.seekerscloud.ecomapi.ecomapi.service.OrdersService;
import com.seekerscloud.ecomapi.ecomapi.util.Generator;
import com.seekerscloud.ecomapi.ecomapi.util.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
@EnableAutoConfiguration
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private Generator generator;

    @Override
    public String createOrders(OrdersRequestDTO dto) {
        String generatedId = generator.generateId(5,12);

        Orders orders= new Orders(generatedId,dto.getOrderDate(), dto.getCost(),dto.getCustomerId(),dto.getUserId());

        return  ordersRepo.save(orders).getOrderId()+" Saved";
    }

    @Override
    public OrdersResponseDTO findOrders(String id) throws ClassNotFoundException {
        Optional<Orders> byId =ordersRepo.findById(id);
        if(byId.isPresent()){
            return ordersMapper.toOrdersResponseDTO(byId.get());
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String updateOrders(OrdersRequestDTO dto, String id) throws ClassNotFoundException {
        Optional<Orders> byId = ordersRepo.findById(id);

        if(byId.isPresent()) {

            byId.get().setOrderDate(dto.getOrderDate());
            byId.get().setCost(dto.getCost());
            byId.get().setUserId(dto.getUserId());
            byId.get().setCustomerId(dto.getCustomerId());
            ordersRepo.save(byId.get());
            return byId.get().getOrderId() + " was updated!";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deleteOrders(String order_id) {

        customerRepo.deleteById(order_id);
        return order_id+ "was deleted";
    }

    @Override
    public PaginatedOrdersResponseDTO findAllOrders(String searchText, int page, int size) {

        return new PaginatedOrdersResponseDTO(
                ordersRepo.countOrders(searchText),
                ordersMapper.toOrdersResponseDTOList(ordersRepo.searchOrders(
                        searchText, PageRequest.of(page, size)
                ))
        );
    }

}
