package com.ccdev.springdatajpa.repositories.repository7;

import com.ccdev.springdatajpa.entities.entity7.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
