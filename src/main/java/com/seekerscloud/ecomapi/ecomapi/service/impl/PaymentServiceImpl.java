package com.seekerscloud.ecomapi.ecomapi.service.impl;

import com.seekerscloud.ecomapi.ecomapi.dto.PaymentDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.request.PaymentRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.PaymentResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedPaymentResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.Payment;
import com.seekerscloud.ecomapi.ecomapi.repo.PaymentRepo;
import com.seekerscloud.ecomapi.ecomapi.service.PaymentService;
import com.seekerscloud.ecomapi.ecomapi.util.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@EnableAutoConfiguration
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private PaymentMapper paymentMapper;
    @Override
    public String createPayment(PaymentRequestDTO dto) {
        Payment payment= new Payment(0,dto.getPayment(), dto.getPaymentType(), dto.getDate(),null);
        PaymentDTO pDto = new PaymentDTO();
        return  paymentRepo.save(payment).getId()+" Saved";
    }

    @Override
    public PaymentResponseDTO findPayment(int id) throws ClassNotFoundException {
        Optional<Payment> byId =paymentRepo.findById(id);
        if(byId.isPresent()){
            return paymentMapper.toPaymentResponseDTO(byId.get());
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String updatePayment(PaymentRequestDTO dto, int id) throws ClassNotFoundException {
        Optional<Payment> byId = paymentRepo.findById(id);

        if(byId.isPresent()) {

            byId.get().setPayment(dto.getPayment());
            byId.get().setPaymentType(dto.getPaymentType());
            byId.get().setDate(dto.getDate());
            paymentRepo.save(byId.get());
            return byId.get().getId() + " was updated!";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deletePayment(int id) {
        paymentRepo.deleteById(id);
        return id+ "was deleted";
    }

    @Override
    public PaginatedPaymentResponseDTO findAllPayment(String searchText, int page, int size) {
        return null;
    }
}
