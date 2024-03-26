package com.ccdev.springdatajpa.repositories.repository7;

import com.ccdev.springdatajpa.entities.entity7.Student7;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student7Repository extends JpaRepository<Student7, Integer> {
}
