package com.seekerscloud.ecomapi.ecomapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO {
    private int code;
    private String description;
    private int qty;
    private double unitPrice;
    private byte[] barcode;
}
