package com.seekerscloud.ecomapi.ecomapi.dto.request;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemRequestDTO {

    private String description;
    private int qty;
    private double unitPrice;
}
