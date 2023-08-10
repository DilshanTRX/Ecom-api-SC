package com.seekerscloud.ecomapi.ecomapi.service;

import com.seekerscloud.ecomapi.ecomapi.dto.request.UserRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.UserResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedUserResponseDTO;

public interface UserService {
    public String createUser(UserRequestDTO dto);
    public UserResponseDTO findUser(String id) throws ClassNotFoundException;
    public String updateUser(UserRequestDTO dto, String id) throws ClassNotFoundException;
    public String deleteUser(String id);
    public PaginatedUserResponseDTO findAllUser(
            String searchText, int page, int size
    );
}
