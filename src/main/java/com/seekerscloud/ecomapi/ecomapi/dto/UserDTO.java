package com.seekerscloud.ecomapi.ecomapi.dto;

import com.seekerscloud.ecomapi.ecomapi.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String id;
    private String email;
    private String name;
    private String password;
    private List<OrdersDTO> ordersDTOS;

    public UserDTO(String id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
