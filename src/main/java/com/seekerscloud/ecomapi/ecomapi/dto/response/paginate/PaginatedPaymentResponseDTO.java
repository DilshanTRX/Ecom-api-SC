package com.seekerscloud.ecomapi.ecomapi.dto.response.paginate;

import com.seekerscloud.ecomapi.ecomapi.dto.response.PaymentResponseDTO;

import java.util.List;

public class PaginatedPaymentResponseDTO {
    private long dataCount;
    private List<PaymentResponseDTO> dataList;
}
