package com.seekerscloud.ecomapi.ecomapi.dto;

import com.seekerscloud.ecomapi.ecomapi.enums.PaymentState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
    private int id;
    private double payment;
    private PaymentState paymentType;
    private Date date;
}
