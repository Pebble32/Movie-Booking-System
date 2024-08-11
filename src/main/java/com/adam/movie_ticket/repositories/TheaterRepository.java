package com.adam.movie_ticket.repositories;

import com.adam.movie_ticket.repositories.entities.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer> {
    TheaterEntity findByAddress(String address);
}
