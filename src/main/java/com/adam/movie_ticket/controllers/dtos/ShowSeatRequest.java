package com.adam.movie_ticket.controllers.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ShowSeatRequest {
    private Integer id;
    private Integer priceOfRegularSeat;
    private Integer priceOfVIPSeat;
}
