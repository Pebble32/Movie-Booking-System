package com.adam.movie_ticket.repositories;

import com.adam.movie_ticket.repositories.entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {

    MovieEntity findByTitleAndReleaseDate(String title, Date releaseDate);
}
