package com.seekerscloud.ecomapi.ecomapi.dto.response;

import com.seekerscloud.ecomapi.ecomapi.entity.OrderHasItem;
import com.seekerscloud.ecomapi.ecomapi.entity.Payment;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersResponseDTO {
    private String orderId;
    private Date orderDate;
    private double cost;
    private List<OrderHasItem> orderOrderId;
    private Payment paymentId;
}
