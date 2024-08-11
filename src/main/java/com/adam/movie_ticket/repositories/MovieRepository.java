package com.adam.movie_ticket.repositories;

import com.adam.movie_ticket.repositories.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
}
