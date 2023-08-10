package com.seekerscloud.ecomapi.ecomapi.util.mapper;

import com.seekerscloud.ecomapi.ecomapi.dto.UserDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.UserResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.User;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserDTO dto);
    UserResponseDTO toUserResponseDTO(User user);
    List<UserResponseDTO> toUserResponseDTOList(List<User> list);
}
