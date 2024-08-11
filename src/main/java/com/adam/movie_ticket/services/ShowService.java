package com.adam.movie_ticket.services;

import com.adam.movie_ticket.controllers.dtos.ShowRequest;
import com.adam.movie_ticket.repositories.MovieRepository;
import com.adam.movie_ticket.repositories.ShowRepository;
import com.adam.movie_ticket.repositories.TheaterRepository;
import com.adam.movie_ticket.repositories.entities.MovieEntity;
import com.adam.movie_ticket.repositories.entities.ShowEntity;
import com.adam.movie_ticket.repositories.entities.TheaterEntity;
import com.adam.movie_ticket.services.converters.ShowConverter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ShowService {


    private final ShowConverter showConverter;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final ShowRepository showRepository;


    public Integer addNewShow(@Valid ShowRequest showRequest) {
        Optional<MovieEntity> movie = movieRepository.findById(showRequest.getMovieId());
        if (movie.isEmpty()) {
            throw new RuntimeException("Movie does not exist");
        }

        Optional<TheaterEntity> theater = theaterRepository.findById(showRequest.getTheaterId());
        if (theater.isEmpty()) {
            throw new RuntimeException("Theater does not exist");
        }

        ShowEntity show = showConverter.dtoToEntity(showRequest);

        TheaterEntity theaterEntity = theater.get();
        MovieEntity movieEntity = movie.get();

        theaterEntity.getShowEntities().add(show);
        movieEntity.getShows().add(show);
        return showRepository.save(show).getId();

    }
}
