package com.adam.movie_ticket.controllers;

import com.adam.movie_ticket.controllers.dtos.ShowRequest;
import com.adam.movie_ticket.controllers.dtos.ShowSeatRequest;
import com.adam.movie_ticket.services.ShowService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/show")
public class ShowController {

    private final ShowService showService;

    @PostMapping("/addNew")
    public ResponseEntity<Integer> addShow(
            @RequestBody @Valid ShowRequest showRequest
    ) {
        return ResponseEntity.ok(showService.addNewShow(showRequest));
    }

    @PostMapping("/associateSeats")
    public ResponseEntity<Integer> associateSeats(
            @RequestBody @Valid ShowSeatRequest showSeatRequest
    ) {
        return ResponseEntity.ok(showService.associateShowSeats(showSeatRequest));
    }

}
