package com.adam.movie_ticket.controllers;

import com.adam.movie_ticket.controllers.dtos.MovieRequest;
import com.adam.movie_ticket.repositories.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieRepository movieRepository;

    @PostMapping("/addNew")
    public ResponseEntity<String> addNewMovie(@RequestBody MovieRequest movieRequest) {
        return null;
    }
}
