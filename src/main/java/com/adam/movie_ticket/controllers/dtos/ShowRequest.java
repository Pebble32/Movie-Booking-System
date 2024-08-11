package com.adam.movie_ticket.controllers.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
@Builder
public class ShowRequest {

    private Time showStartTime;
    private Date showDate;
    private Integer theaterId;
    private Integer movieId;
}
