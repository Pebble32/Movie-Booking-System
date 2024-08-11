package com.adam.movie_ticket.repositories.entities;

import com.adam.movie_ticket.enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShowSeatEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;

    private Boolean isAvailable;

    private Boolean containsFood;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;
}
