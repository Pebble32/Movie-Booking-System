package com.adam.movie_ticket.controllers.dtos;

import lombok.Data;

@Data
public class TheaterSeatRequest {
    private String address;
    private Integer noOfSeatsRow;
    private Integer noOfVIPSeats;
    private Integer noOfRegularSeats;
}
