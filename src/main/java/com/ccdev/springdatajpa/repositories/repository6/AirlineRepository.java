package com.ccdev.springdatajpa.repositories.repository6;

import com.ccdev.springdatajpa.entities.entity6.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}
