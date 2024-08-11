package com.adam.movie_ticket.services.converters;

import com.adam.movie_ticket.controllers.dtos.TicketResponse;
import com.adam.movie_ticket.repositories.entities.ShowEntity;
import com.adam.movie_ticket.repositories.entities.TicketEntity;

public class TicketConverter {
    public static TicketResponse returnTicket(ShowEntity showEntity, TicketEntity ticketEntity) {
        return TicketResponse.builder()
                .bookedSeats(ticketEntity.getBookedSeats())
                .address(showEntity.getTheater().getAddress())
                .theaterName(showEntity.getTheater().getName())
                .movieName(showEntity.getMovie().getTitle())
                .date(showEntity.getDate())
                .time(showEntity.getTime())
                .totalPrice(ticketEntity.getTotalPrice())
                .build();
    }
}
