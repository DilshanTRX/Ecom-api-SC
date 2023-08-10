package com.seekerscloud.ecomapi.ecomapi.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerRequestDTO {
    private String name;
    private String address;
    private double salary;
}
