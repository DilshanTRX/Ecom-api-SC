package com.seekerscloud.ecomapi.ecomapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponseDTO {
    private int code;
    private String description;
    private int qty;
    private double unitPrice;
    private byte[] barcode;
}
