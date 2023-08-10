package com.seekerscloud.ecomapi.ecomapi.dto;

import com.seekerscloud.ecomapi.ecomapi.entity.Item;
import com.seekerscloud.ecomapi.ecomapi.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderHasItemDTO {
    private Orders orderOrderId;
    private Item itemCode;
    private double unitPrice;
    private int qty;
}
