package com.ccdev.springdatajpa.repositories.repository3;

import com.ccdev.springdatajpa.entities.entity3.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MagazineRepository extends JpaRepository<Magazine, Long> {
}
