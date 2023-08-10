package com.seekerscloud.ecomapi.ecomapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "customer_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Customer {
    @Id
    @Column(name = "id",unique = true)
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "salary")
    private double salary;

    @OneToMany(mappedBy = "customerId",cascade = CascadeType.ALL)
    private List<Orders> ordersList;
}
