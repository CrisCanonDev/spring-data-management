package com.ccdev.springdatajpa.repositories.repository2;

import com.ccdev.springdatajpa.entities.entity1.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Student, Long> {
}
