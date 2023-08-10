package com.seekerscloud.ecomapi.ecomapi.service.impl;

import com.seekerscloud.ecomapi.ecomapi.dto.request.OrderHasItemRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.OrderHasItemResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedOrderHasItemResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.OrderHasItem;
import com.seekerscloud.ecomapi.ecomapi.entity.compositekey.OrderHasItemId;
import com.seekerscloud.ecomapi.ecomapi.repo.OrderHasItemRepo;
import com.seekerscloud.ecomapi.ecomapi.service.OrderHasItemService;
import com.seekerscloud.ecomapi.ecomapi.util.mapper.OrderHasItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@EnableAutoConfiguration
public class OrderHasItemServiceImpl implements OrderHasItemService {

    @Autowired
    private OrderHasItemRepo orderhasitemRepo;

    @Autowired
    private OrderHasItemRepo orderHasItemRepo;

    @Autowired
    private OrderHasItemMapper orderhasitemMapper;

    @Autowired
    public OrderHasItemServiceImpl(OrderHasItemRepo order_has_itemRepo) {
        this.orderhasitemRepo = order_has_itemRepo;
    }

    @Override
    public String createOrderHasItem(OrderHasItemRequestDTO dto) {


            OrderHasItem orderhasitem = new OrderHasItem(dto.getOrderOrderId().getOrderId(), dto.getItemCode().getCode(), dto.getUnitPrice(), dto.getQty());
        return orderhasitemRepo.save(orderhasitem).getOrderOrderId() + " Saved";
    }

    @Override
    public OrderHasItemResponseDTO findOrderHasItem(String orderOrderId) throws ClassNotFoundException {
        Optional<OrderHasItem> byId = orderhasitemRepo.findByOrderOrderId(orderOrderId);
        if (byId.isPresent()) {
            return orderhasitemMapper.toOrderHasItemResponseDTO(byId.get());
        }
        throw new ClassNotFoundException("Not Found");

    }

    @Override
    public String updateOrderHasItem(OrderHasItemRequestDTO dto, String orderOrderId) throws ClassNotFoundException {
        Optional<OrderHasItem> byId = orderhasitemRepo.findByOrderOrderId(orderOrderId);

        if (byId.isPresent()) {

            byId.get().setUnitPrice(dto.getUnitPrice());
            byId.get().setQty(dto.getQty());
            orderhasitemRepo.save(byId.get());
            return byId.get().getOrderOrderId() + " was updated!";
        }
        throw new ClassNotFoundException("Not Found");
    }



    @Override
    public String deleteOrderHasItem(String orderOrderId, int itemCode) {
        OrderHasItemId orderHasItemId = new OrderHasItemId(orderOrderId, itemCode);
        orderHasItemRepo.deleteByOrderHasItemId(orderHasItemId);
        return "Order item deleted";
    }

    @Override
    public PaginatedOrderHasItemResponseDTO findAllOrderHasItem(String searchText, int page, int size) {

        return new PaginatedOrderHasItemResponseDTO(
                orderhasitemRepo.countOrderHasItem(searchText),
                orderhasitemMapper.toOrderHasItemResponseDTOList(orderhasitemRepo.searchOrderHasItem(
                        searchText, PageRequest.of(page, size)
                ))
        );
    }

}
