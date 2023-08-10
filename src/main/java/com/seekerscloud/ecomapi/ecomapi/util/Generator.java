package com.seekerscloud.ecomapi.ecomapi.util;


import com.seekerscloud.ecomapi.ecomapi.repo.CustomerRepo;
import com.seekerscloud.ecomapi.ecomapi.repo.OrdersRepo;
import com.seekerscloud.ecomapi.ecomapi.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class Generator {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrdersRepo orderRepo;

    public final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generateId(int min,int max){

        String stringBuilder = getStringBuilder(min, max).toString();
        while(userRepo.existsById(stringBuilder) || customerRepo.existsById(stringBuilder) || orderRepo.existsById(stringBuilder)){
          stringBuilder =  getStringBuilder(min, max).toString();
        }
        return stringBuilder;
    }

    private StringBuilder getStringBuilder(int min, int max) {
        int generatedRand = generateRand(min, max);
        StringBuilder builder = new StringBuilder();
        for (int i =0; i < generatedRand; i++){
            builder.append(ALPHABET.charAt(new Random().nextInt(ALPHABET.length()-1)));
        }
        return builder;
    }

    private int generateRand(int min, int max){
        return new Random().nextInt((max-min)+min)+min;
    }
}
