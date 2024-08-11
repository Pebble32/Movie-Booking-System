package com.adam.movie_ticket.services.converters;

import com.adam.movie_ticket.controllers.dtos.TheaterRequest;
import com.adam.movie_ticket.repositories.entities.TheaterEntity;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class TheaterConverter {


    public TheaterEntity dtoToEntity(@Valid TheaterRequest theaterRequest) {
        return TheaterEntity.builder()
                .name(theaterRequest.getTheaterName())
                .address(theaterRequest.getTheaterAddress())
                .build();
    }
}
