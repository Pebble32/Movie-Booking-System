package com.adam.movie_ticket.services;

import com.adam.movie_ticket.controllers.dtos.MovieRequest;
import com.adam.movie_ticket.repositories.MovieRepository;
import com.adam.movie_ticket.repositories.entities.MovieEntity;
import com.adam.movie_ticket.services.converters.MovieConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieConverter movieConverter;

    public Integer addNewMovie(MovieRequest movieRequest) {
        MovieEntity movieEntity = movieRepository.findByTitleAndReleaseDate(
                movieRequest.getTitle(),
                movieRequest.getReleaseDate()
        );

        if (movieEntity != null && movieEntity.getLanguage().equals(movieRequest.getLanguage())) {
            throw new RuntimeException("Movie with this language already already exists");
        }



        return movieRepository.save(movieConverter.dtoToEntity(movieRequest)).getId();
    }
}
