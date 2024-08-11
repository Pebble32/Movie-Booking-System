package com.adam.movie_ticket.controllers.dtos;


import com.adam.movie_ticket.enums.Genre;
import com.adam.movie_ticket.enums.Language;
import lombok.Data;

import java.util.Date;

@Data
public class MovieRequest {
    private String title;
    private Integer duration;
    private String description;
    private Integer rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}
