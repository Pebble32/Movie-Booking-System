package com.adam.movie_ticket.controllers.dtos;

import lombok.Data;

@Data
public class TheaterRequest {
    private String theaterName;
    private String theaterAddress;
}
