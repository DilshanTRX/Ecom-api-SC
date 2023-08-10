package com.seekerscloud.ecomapi.ecomapi.service.impl;

import com.seekerscloud.ecomapi.ecomapi.dto.CustomerDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.UserDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.request.UserRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.UserResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedCustomerResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.dto.response.paginate.PaginatedUserResponseDTO;
import com.seekerscloud.ecomapi.ecomapi.entity.Customer;
import com.seekerscloud.ecomapi.ecomapi.entity.User;
import com.seekerscloud.ecomapi.ecomapi.repo.UserRepo;
import com.seekerscloud.ecomapi.ecomapi.service.UserService;
import com.seekerscloud.ecomapi.ecomapi.util.Generator;
import com.seekerscloud.ecomapi.ecomapi.util.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
@EnableAutoConfiguration
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserMapper userMapper;
    private final Generator generator;

    public UserServiceImpl(Generator generator) {
        this.generator = generator;
    }

    @Override
    public String createUser(UserRequestDTO dto) {
        String generatedId = generator.generateId(5,12);
        UserDTO userDTO = new UserDTO(generatedId, dto.getEmail(), dto.getName(), dto.getPassword());
        User user = userMapper.toUser(userDTO);
        return  userRepo.save(user).getId()+" Saved";
    }

    @Override
    public UserResponseDTO findUser(String id) throws ClassNotFoundException {
        Optional<User> byId =userRepo.findById(id);
        if(byId.isPresent()){
            return userMapper.toUserResponseDTO(byId.get());
        }
        throw new ClassNotFoundException("Not Found");
    }



    @Override
    public String updateUser(UserRequestDTO dto, String id) throws ClassNotFoundException {
        Optional<User> byId = userRepo.findById(id);

        if(byId.isPresent()) {

            byId.get().setName(dto.getName());
            byId.get().setEmail(dto.getEmail());
            byId.get().setPassword(dto.getPassword());
            userRepo.save(byId.get());
            return byId.get().getName() + " was updated!";
        }
        throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deleteUser(String id) {

        userRepo.deleteById(id);
        return id+ "was deleted";
    }

    @Override
    public PaginatedUserResponseDTO findAllUser(String searchText, int page, int size) {

        return new PaginatedUserResponseDTO(
                userRepo.countUser(searchText),
                userMapper.toUserResponseDTOList(userRepo.searchUser(
                        searchText, PageRequest.of(page, size)
                ))
        );
    }
}
