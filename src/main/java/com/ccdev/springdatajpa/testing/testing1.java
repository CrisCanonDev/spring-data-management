package com.ccdev.springdatajpa.testing;

import com.ccdev.springdatajpa.entities.entity1.Address;
import com.ccdev.springdatajpa.entities.entity1.Student;
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
        Address address  = new Address();
        address.setCity("Medellin");
        address.setStreet("Street 2");

        Student student = new Student();
        student.setName("Juan David prev");
        student.setAddress(address);

        System.out.println("Prev student name: "+ student.getName());
        studentRepository.save(student);

        student.setName("Samantha new");
        studentRepository.save(student);

        System.out.println("new student name: "+ student.getName() );

        Iterable<Student> students = studentRepository.findAll();
        for(Student s: students){
            System.out.println(s.getId() + ". Name: " + s.getName() + ", Address: "+s.getAddress());
        }
    }
}
