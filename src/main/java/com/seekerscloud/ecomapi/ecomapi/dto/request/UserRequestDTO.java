package com.seekerscloud.ecomapi.ecomapi.dto.request;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserRequestDTO {

    private String email;
    private String name;
    private String password;
}
