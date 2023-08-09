package com.seekerscloud.ecomapi.ecomapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity(name = "orders_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Orders {
    @Id
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "cost")
    private double cost;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private Customer customerId;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User userId;


    @OneToMany(mappedBy = "orderOrderId")
    private List<Order_Has_Item> orderOrderId;

    @OneToOne(mappedBy = "orderOrderId")
    private Payment paymentId;
}
