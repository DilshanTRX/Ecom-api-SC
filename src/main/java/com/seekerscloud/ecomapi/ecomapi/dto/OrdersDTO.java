package com.seekerscloud.ecomapi.ecomapi.dto;

import com.seekerscloud.ecomapi.ecomapi.entity.Customer;
import com.seekerscloud.ecomapi.ecomapi.entity.OrderHasItem;
import com.seekerscloud.ecomapi.ecomapi.entity.Payment;
import com.seekerscloud.ecomapi.ecomapi.entity.User;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdersDTO {
    private String orderId;
    private Date orderDate;
    private double cost;
    private Customer customerId;
    private User userId;
    private List<OrderHasItem> orderOrderId;
    private Payment paymentId;
}
