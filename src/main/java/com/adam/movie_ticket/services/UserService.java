package com.adam.movie_ticket.services;

import com.adam.movie_ticket.controllers.dtos.UserRequest;
import com.adam.movie_ticket.repositories.UserRepository;
import com.adam.movie_ticket.services.converters.UserConverter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public Integer addUser(@Valid UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }

        return userRepository.save(userConverter.dtoToEntity(userRequest)).getId();

    }
}
