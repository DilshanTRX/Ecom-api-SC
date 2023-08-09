package com.seekerscloud.ecomapi.ecomapi.entity;

import com.seekerscloud.ecomapi.ecomapi.enums.PaymentState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity(name = "payment_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "payment")
    private double payment;
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentState paymentType;
    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "order_order_id",unique = true)
    private Orders orderOrderId;
}
