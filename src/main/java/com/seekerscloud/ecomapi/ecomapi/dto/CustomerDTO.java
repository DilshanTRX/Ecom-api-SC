package com.seekerscloud.ecomapi.ecomapi.dto;

import jakarta.persistence.Column;

public class CustomerDTO {
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "salary")
    private double salary;
}
