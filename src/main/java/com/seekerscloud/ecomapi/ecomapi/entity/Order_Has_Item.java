package com.seekerscloud.ecomapi.ecomapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "orders_has_item_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Order_Has_Item {
    @Id
    @ManyToOne
    @JoinColumn(name = "order_order_id")
    private Orders orderOrderId;
    @ManyToOne()
    @JoinColumn(name = "item_code")
    private Item itemCode;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "qty")
    private int qty;

}
