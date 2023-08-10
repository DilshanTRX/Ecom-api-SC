package com.seekerscloud.ecomapi.ecomapi.dto.response;

import com.seekerscloud.ecomapi.ecomapi.dto.OrdersDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private String id;
    private String email;
    private String name;
    private String password;
    private List<OrdersDTO> ordersDTOS;

    public UserResponseDTO(String id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
