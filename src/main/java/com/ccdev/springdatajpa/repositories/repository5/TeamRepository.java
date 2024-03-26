package com.ccdev.springdatajpa.repositories.repository5;

import com.ccdev.springdatajpa.entities.entity5.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
