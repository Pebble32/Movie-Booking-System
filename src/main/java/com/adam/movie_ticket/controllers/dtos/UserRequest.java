package com.adam.movie_ticket.controllers.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private String username;
    private Integer age;
    private String address;
    private String mobileNo;
    private String email;
    private String roles;
}
