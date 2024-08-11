package com.adam.movie_ticket.repositories.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private Time time;
    private Date date;

    @ManyToOne
    @JoinColumn
    private MovieEntity movie;

    @ManyToOne
    @JoinColumn
    private TheaterEntity theater;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeatEntity> showSeatEntityList;

    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntityList;
}
