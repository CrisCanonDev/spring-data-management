package com.ccdev.springdatajpa.repositories.repository4;

import com.ccdev.springdatajpa.entities.entity4.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
