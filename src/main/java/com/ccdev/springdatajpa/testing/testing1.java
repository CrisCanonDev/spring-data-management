package com.ccdev.springdatajpa.testing;

import com.ccdev.springdatajpa.entities.entity1.Address;
import com.ccdev.springdatajpa.repositories.repository1.AddressRepository;
import com.ccdev.springdatajpa.repositories.repository1.StudentRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class testing1 implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
