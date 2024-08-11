package com.adam.movie_ticket.controllers;

import com.adam.movie_ticket.controllers.dtos.MovieRequest;
import com.adam.movie_ticket.services.MovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;


    @PostMapping("/addNew")
    public ResponseEntity<Integer> addNewMovie(
            @RequestBody @Valid MovieRequest movieRequest
    ) {
        return ResponseEntity.ok(movieService.addNewMovie(movieRequest));
    }


}
