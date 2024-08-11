package com.adam.movie_ticket.services.converters;

import com.adam.movie_ticket.controllers.dtos.ShowRequest;
import com.adam.movie_ticket.repositories.entities.ShowEntity;
import org.springframework.stereotype.Service;

@Service
public class ShowConverter {

    public ShowEntity dtoToEntity(ShowRequest showRequest) {
        return ShowEntity.builder()
                .time(showRequest.getShowStartTime())
                .date(showRequest.getShowDate())
                .build();
    }
}
