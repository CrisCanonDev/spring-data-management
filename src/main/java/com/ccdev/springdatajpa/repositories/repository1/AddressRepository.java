package com.ccdev.springdatajpa.repositories.repository1;

import com.ccdev.springdatajpa.entities.entity1.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
