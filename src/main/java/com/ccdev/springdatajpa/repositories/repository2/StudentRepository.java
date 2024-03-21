package com.ccdev.springdatajpa.repositories.repository2;

import com.ccdev.springdatajpa.entities.entity1.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
