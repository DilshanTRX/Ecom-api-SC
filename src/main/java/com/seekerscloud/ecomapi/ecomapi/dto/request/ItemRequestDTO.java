package com.seekerscloud.ecomapi.ecomapi.dto.request;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemRequestDTO {

    @Column(name = "description")
    private String description;
    @Column(name = "qty")
    private int qty;
    @Column(name = "unit_price")
    private double unitPrice;
}
