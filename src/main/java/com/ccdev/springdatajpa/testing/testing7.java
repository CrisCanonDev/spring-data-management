package com.ccdev.springdatajpa.testing;

import com.ccdev.springdatajpa.entities.entity7.Lecture;
import com.ccdev.springdatajpa.entities.entity7.Student7;
import com.ccdev.springdatajpa.repositories.repository7.LectureRepository;
import com.ccdev.springdatajpa.repositories.repository7.Student7Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class testing7 implements CommandLineRunner {
    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private Student7Repository student7Repository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Lecture lecture1 = new Lecture();
        lecture1.setName("Mathematics");

        Lecture lecture2 = new Lecture();
        lecture2.setName("Chemistry");

        Student7 student1 = new Student7();
        student1.setName("Juan");

        Student7 student2 = new Student7();
        student2.setName("Anne");

        student1.getLectures().add(lecture1);
        student1.getLectures().add(lecture2);

        student2.getLectures().add(lecture1);


        student7Repository.save(student1);
        student7Repository.save(student2);

        //Searching
        Student7 studentRetrieved = student7Repository.findById(1).orElse(null);
        System.out.println("Student retrieved: "+ studentRetrieved.getName());

        Lecture lectureRetrieved = lectureRepository.findById(1).orElse(null);
        System.out.println("Lecture retrieved: "+ lectureRetrieved.getName());

        //Deleting an student by ID using repository
        student7Repository.deleteById(1);

        //Deleting a lecture by ID
        lectureRepository.deleteById(1);



    }
}
