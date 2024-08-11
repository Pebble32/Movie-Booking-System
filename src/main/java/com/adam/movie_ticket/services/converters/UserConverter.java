package com.adam.movie_ticket.services.converters;

import com.adam.movie_ticket.controllers.dtos.UserRequest;
import com.adam.movie_ticket.repositories.entities.UserEntity;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {


    public UserEntity dtoToEntity(@Valid UserRequest userRequest) {
        return UserEntity.builder()
                .username(userRequest.getUsername())
                .age(userRequest.getAge())
                .address(userRequest.getAddress())
                .mobileNo(userRequest.getMobileNo())
                .email(userRequest.getEmail())
                .roles(userRequest.getRoles())
                .build();
    }
}
