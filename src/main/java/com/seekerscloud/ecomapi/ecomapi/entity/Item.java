package com.seekerscloud.ecomapi.ecomapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "item_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code")
    private int code;
    @Column(name = "description")
    private String description;
    @Column(name = "qty")
    private int qty;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "barcode")
    private String barcode;
    @OneToMany(mappedBy = "itemCode",cascade = CascadeType.ALL)
    private List<Order_Has_Item> ordersList;
}
