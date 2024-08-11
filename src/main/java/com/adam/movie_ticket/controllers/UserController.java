package com.adam.movie_ticket.controllers;

import com.adam.movie_ticket.controllers.dtos.UserRequest;
import com.adam.movie_ticket.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/addNew")
    public ResponseEntity<Integer> addNewUser(
            @RequestBody @Valid UserRequest userRequest
    ) {
        return ResponseEntity.ok(userService.addUser(userRequest));
    }
}
