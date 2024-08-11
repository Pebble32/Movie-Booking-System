package com.adam.movie_ticket.controllers;

import com.adam.movie_ticket.controllers.dtos.TheaterRequest;
import com.adam.movie_ticket.repositories.TheaterRepository;
import com.adam.movie_ticket.services.TheaterService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/theater")
public class TheaterController {

    private final TheaterService theaterService;

    @PostMapping("/addNew")
    public ResponseEntity<Integer> addNewTheater(
            @RequestBody @Valid TheaterRequest theaterRequest
    ) {
        return ResponseEntity.ok(theaterService.addNewTheater(theaterRequest));
    }

}
