package com.seekerscloud.ecomapi.ecomapi.dto.request;

import com.seekerscloud.ecomapi.ecomapi.entity.Item;
import com.seekerscloud.ecomapi.ecomapi.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHasItemRequestDTO {
    private Orders orderOrderId;
    private Item itemCode;
    private double unitPrice;
    private int qty;
}
