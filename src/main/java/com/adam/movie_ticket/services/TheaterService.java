package com.adam.movie_ticket.services;

import com.adam.movie_ticket.controllers.dtos.TheaterRequest;
import com.adam.movie_ticket.repositories.TheaterRepository;
import com.adam.movie_ticket.repositories.entities.TheaterEntity;
import com.adam.movie_ticket.services.converters.TheaterConverter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;
    private final TheaterConverter theaterConverter;

    public Integer addNewTheater(@Valid TheaterRequest theaterRequest) {
        if (theaterRepository.findByAddress(theaterRequest.getTheaterAddress()) != null) {
            throw new RuntimeException("There is already a theater registered with that address");
        }

        TheaterEntity theaterEntity = theaterConverter.dtoToEntity(theaterRequest);

        return theaterRepository.save(theaterEntity).getId();
    }
}
