package com.seekerscloud.ecomapi.ecomapi.dto.response;

import com.seekerscloud.ecomapi.ecomapi.enums.PaymentState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {
    private int id;
    private double payment;
    private PaymentState paymentType;
    private Date date;
}
