package com.seekerscloud.ecomapi.ecomapi.dto.request;

import com.seekerscloud.ecomapi.ecomapi.enums.PaymentState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {
    private double payment;
    private PaymentState paymentType;
    private Date date;
}
