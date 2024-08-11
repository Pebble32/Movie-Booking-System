package com.adam.movie_ticket.services.converters;

import com.adam.movie_ticket.controllers.dtos.MovieRequest;
import com.adam.movie_ticket.repositories.entities.MovieEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieConverter {

    public MovieEntity dtoToEntity(MovieRequest movieRequest) {
        return MovieEntity.builder()
                .title(movieRequest.getTitle())
                .duration(movieRequest.getDuration())
                .description(movieRequest.getDescription())
                .rating(movieRequest.getRating())
                .releaseDate(movieRequest.getReleaseDate())
                .genre(movieRequest.getGenre())
                .language(movieRequest.getLanguage())
                .build();
    }
}
