package com.adam.movie_ticket.services;

import com.adam.movie_ticket.controllers.dtos.TicketRequest;
import com.adam.movie_ticket.controllers.dtos.TicketResponse;
import com.adam.movie_ticket.repositories.ShowRepository;
import com.adam.movie_ticket.repositories.UserRepository;
import com.adam.movie_ticket.repositories.entities.ShowEntity;
import com.adam.movie_ticket.repositories.entities.ShowSeatEntity;
import com.adam.movie_ticket.repositories.entities.TicketEntity;
import com.adam.movie_ticket.repositories.entities.UserEntity;
import com.adam.movie_ticket.services.converters.TicketConverter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TicketService {

    private final UserRepository userRepository;
    private final ShowRepository showRepository;

    public TicketResponse bookTickets(@Valid TicketRequest ticketRequest) {
        Optional<ShowEntity> show = showRepository.findById(ticketRequest.getShowId());
        if (show.isEmpty()) {
            throw new RuntimeException("Show does not exist");
        }

        Optional<UserEntity> user = userRepository.findById(ticketRequest.getUserId());
        if (user.isEmpty()) {
            throw new RuntimeException("User does not exist");
        }
        ShowEntity showEntity = show.get();
        UserEntity userEntity = user.get();

        Boolean isSeatAvailable = isSeatAvailable(showEntity.getShowSeatEntityList(), ticketRequest.getRequestSeats());
        if (!isSeatAvailable) {
            throw new RuntimeException("Seat is not available");
        }
        
        Integer getPriceAndAssignSeats = getPriceAndAssignSeats(showEntity.getShowSeatEntityList(), ticketRequest.getRequestSeats());

        String bookedSeats = listToString(ticketRequest.getRequestSeats());

        TicketEntity ticket = TicketEntity.builder()
                .totalPrice(getPriceAndAssignSeats)
                .show(showEntity)
                .bookedSeats(bookedSeats)
                .user(userEntity)
                .build();

        userEntity.getTicketEntityList().add(ticket);
        showEntity.getTicketEntityList().add(ticket);
        userRepository.save(userEntity);
        showRepository.save(showEntity);

        return TicketConverter.returnTicket(showEntity, ticket);

    }

    private Integer getPriceAndAssignSeats(List<ShowSeatEntity> showSeatEntityList, List<String> ticketRequest) {
        Integer total = 0;

        for (ShowSeatEntity showSeatEntity : showSeatEntityList) {
            if(ticketRequest.contains(showSeatEntity.getSeatNo())) {
                total += showSeatEntity.getPrice();
                showSeatEntity.setIsAvailable(false);
            }
        }
        return total;
    }

    private Boolean isSeatAvailable(List<ShowSeatEntity> showSeatEntityList, List<String> requestSeats) {
        for (ShowSeatEntity showSeatEntity : showSeatEntityList) {
            String seatNo = showSeatEntity.getSeatNo();
            if (requestSeats.contains(seatNo) && !showSeatEntity.getIsAvailable()) {
                return false;
            }
        }
        return true;
    }

    private String listToString(List<String> requestSeats) {
        StringBuilder sb = new StringBuilder();

        for (String s : requestSeats) {
            sb.append(s).append(",");
        }

        return sb.toString();
    }
}
