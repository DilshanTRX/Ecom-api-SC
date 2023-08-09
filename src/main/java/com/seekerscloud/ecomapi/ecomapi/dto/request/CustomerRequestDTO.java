package com.seekerscloud.ecomapi.ecomapi.dto.request;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor

public class CustomerRequestDTO {
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "salary")
    private double salary;
}
