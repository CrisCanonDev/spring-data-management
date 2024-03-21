package com.ccdev.springdatajpa.repositories.repository1;

import com.ccdev.springdatajpa.entities.entity1.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
