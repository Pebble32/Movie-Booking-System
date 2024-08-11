package com.adam.movie_ticket.services;

import com.adam.movie_ticket.controllers.dtos.ShowRequest;
import com.adam.movie_ticket.controllers.dtos.ShowSeatRequest;
import com.adam.movie_ticket.enums.SeatType;
import com.adam.movie_ticket.repositories.MovieRepository;
import com.adam.movie_ticket.repositories.ShowRepository;
import com.adam.movie_ticket.repositories.TheaterRepository;
import com.adam.movie_ticket.repositories.entities.*;
import com.adam.movie_ticket.services.converters.ShowConverter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShowService {


    private final ShowConverter showConverter;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final ShowRepository showRepository;


    public Integer addNewShow(@Valid ShowRequest showRequest) {
        Optional<MovieEntity> movie = movieRepository.findById(showRequest.getMovieId());
        if (movie.isEmpty()) {
            throw new RuntimeException("Movie does not exist");
        }

        Optional<TheaterEntity> theater = theaterRepository.findById(showRequest.getTheaterId());
        if (theater.isEmpty()) {
            throw new RuntimeException("Theater does not exist");
        }

        ShowEntity show = showConverter.dtoToEntity(showRequest);

        TheaterEntity theaterEntity = theater.get();
        MovieEntity movieEntity = movie.get();

        theaterEntity.getShowEntities().add(show);
        movieEntity.getShows().add(show);
        return showRepository.save(show).getId();

    }

    public Integer associateShowSeats(@Valid ShowSeatRequest showSeatRequest) {
        Optional<ShowEntity> show = showRepository.findById(showSeatRequest.getId());
        if (show.isEmpty()) {
            throw new RuntimeException("Show does not exist");
        }

        ShowEntity showEntity = show.get();
        TheaterEntity theaterEntity = show.get().getTheater();

        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntities();
        List<ShowSeatEntity> showSeatEntityList = show.get().getShowSeatEntityList();

        for (TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList) {
            ShowSeatEntity showSeatEntity = getShowSeatEntity(showSeatRequest, theaterSeatEntity, showEntity);
            showSeatEntityList.add(showSeatEntity);
        }

        return showRepository.save(showEntity).getId();

    }

    private static ShowSeatEntity getShowSeatEntity(ShowSeatRequest showSeatRequest, TheaterSeatEntity theaterSeatEntity, ShowEntity showEntity) {
        ShowSeatEntity showSeatEntity = new ShowSeatEntity();
        showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNumber());
        showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());


        if (showSeatEntity.getSeatType().equals(SeatType.REGULAR)){
            showSeatEntity.setPrice(showSeatRequest.getPriceOfRegularSeat());
            showSeatEntity.setContainsFood(false);
        } else {
            showSeatEntity.setPrice(showSeatRequest.getPriceOfVIPSeat());
            showSeatEntity.setContainsFood(true);
        }

        showSeatEntity.setShow(showEntity);
        showSeatEntity.setIsAvailable(true);
        return showSeatEntity;
    }
}
