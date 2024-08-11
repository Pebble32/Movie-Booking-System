package com.adam.movie_ticket.services;

import com.adam.movie_ticket.controllers.dtos.TheaterRequest;
import com.adam.movie_ticket.controllers.dtos.TheaterSeatRequest;
import com.adam.movie_ticket.enums.SeatType;
import com.adam.movie_ticket.repositories.TheaterRepository;
import com.adam.movie_ticket.repositories.entities.TheaterEntity;
import com.adam.movie_ticket.repositories.entities.TheaterSeatEntity;
import com.adam.movie_ticket.services.converters.TheaterConverter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;
    private final TheaterConverter theaterConverter;

    public Integer addNewTheater(@Valid TheaterRequest theaterRequest) {
        if (theaterRepository.findByAddress(theaterRequest.getTheaterAddress()) != null) {
            throw new RuntimeException("There is already a theater registered with that address");
        }

        TheaterEntity theaterEntity = theaterConverter.dtoToEntity(theaterRequest);

        return theaterRepository.save(theaterEntity).getId();
    }

    public Integer addTheaterSeats(@Valid TheaterSeatRequest theaterSeatRequest) {
        TheaterEntity theater = validateAndGetTheater(theaterSeatRequest.getAddress());

        List<TheaterSeatEntity> seatList = theater.getTheaterSeatEntities();

        generateAndAddSeats(seatList, theater, theaterSeatRequest.getNoOfRegularSeats(),
                theaterSeatRequest.getNoOfSeatsRow(), SeatType.REGULAR);

        generateAndAddSeats(seatList, theater, theaterSeatRequest.getNoOfVIPSeats(),
                theaterSeatRequest.getNoOfVIPSeats(), SeatType.VIP);

        return theaterRepository.save(theater).getId();
    }

    private TheaterEntity validateAndGetTheater(String address) {
        TheaterEntity theater = theaterRepository.findByAddress(address);
        if (theater == null) {
            throw new RuntimeException("There is no theater registered with that address");
        }
        return theater;
    }

    private void generateAndAddSeats(List<TheaterSeatEntity> seatList, TheaterEntity theater,
                                     Integer noOfSeats, Integer noOfSeatsInRow, SeatType seatType) {
        int counter = 1;
        int fill = 0;
        char ch = 'A';

        for (int i = 1; i <= noOfSeats; i++) {
            String seatNo = generateSeatNumber(counter, ch);
            TheaterSeatEntity theaterSeat = createTheaterSeat(seatNo, seatType, theater);
            seatList.add(theaterSeat);

            counter++;
            fill++;
            if (fill == noOfSeatsInRow) {
                ch++;
                fill = 0;
                counter = 1;
            }
        }
    }

    private String generateSeatNumber(int counter, char ch) {
        return Integer.toString(counter) + ch;
    }

    private TheaterSeatEntity createTheaterSeat(String seatNo, SeatType seatType, TheaterEntity theater) {
        TheaterSeatEntity theaterSeat = new TheaterSeatEntity();
        theaterSeat.setSeatNumber(seatNo);
        theaterSeat.setSeatType(seatType);
        theaterSeat.setTheater(theater);
        return theaterSeat;
    }

}
