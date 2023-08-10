package com.seekerscloud.ecomapi.ecomapi.service;


import com.seekerscloud.ecomapi.ecomapi.dto.request.PaymentRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.PaymentResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedPaymentResponseDTO;

public interface PaymentService {
    public String createPayment(PaymentRequestDTO dto);
    public PaymentResponseDTO findPayment(int id) throws ClassNotFoundException;
    public String updatePayment(PaymentRequestDTO dto, int id) throws ClassNotFoundException;
    public String deletePayment(int id);
    public PaginatedPaymentResponseDTO findAllPayment(
            String searchText, int page, int size
    );
}
