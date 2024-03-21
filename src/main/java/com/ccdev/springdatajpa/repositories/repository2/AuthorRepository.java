package com.ccdev.springdatajpa.repositories.repository2;

import com.ccdev.springdatajpa.entities.entity2.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
