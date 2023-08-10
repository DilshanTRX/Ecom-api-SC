package com.seekerscloud.ecomapi.ecomapi.dto.request;

import com.seekerscloud.ecomapi.ecomapi.entity.Customer;
import com.seekerscloud.ecomapi.ecomapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersRequestDTO {
    private String orderId;
    private Date orderDate;
    private double cost;
    private Customer customerId;
    private User userId;
}
