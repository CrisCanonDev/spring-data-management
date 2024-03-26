package com.ccdev.springdatajpa.repositories.repository4;

import com.ccdev.springdatajpa.entities.entity4.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
