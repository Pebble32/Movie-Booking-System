package com.adam.movie_ticket.controllers;

import com.adam.movie_ticket.controllers.dtos.TicketRequest;
import com.adam.movie_ticket.controllers.dtos.TicketResponse;
import com.adam.movie_ticket.services.TicketService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/bookTickets")
    public ResponseEntity<TicketResponse> bookTickets(
            @RequestBody @Valid TicketRequest ticketRequest
    ) {
        return ResponseEntity.ok(ticketService.bookTickets(ticketRequest));
    }
}
