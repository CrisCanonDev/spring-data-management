package com.ccdev.springdatajpa.repositories.repository6;

import com.ccdev.springdatajpa.entities.entity6.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
