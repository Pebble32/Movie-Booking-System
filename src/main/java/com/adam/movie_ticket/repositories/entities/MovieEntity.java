package com.adam.movie_ticket.repositories.entities;

import com.adam.movie_ticket.enums.Genre;
import com.adam.movie_ticket.enums.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String title;
    private Integer duration;
    private String description;

    @Column(scale = 2)
    private Integer rating;
    @Column(nullable = false)
    private Date releaseDate;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    @Enumerated(value = EnumType.STRING)
    private Language language;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<ShowEntity> shows;
}
