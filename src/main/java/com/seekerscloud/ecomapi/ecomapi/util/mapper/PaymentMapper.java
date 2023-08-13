package com.seekerscloud.ecomapi.ecomapi.util.mapper;
import com.seekerscloud.ecomapi.ecomapi.dto.PaymentDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.PaymentResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    Payment toPayment(PaymentDTO dto);
    PaymentResponseDTO toPaymentResponseDTO(Payment payment);
    List<PaymentResponseDTO> toPaymentResponseDTOList(List<Payment> list);
}
