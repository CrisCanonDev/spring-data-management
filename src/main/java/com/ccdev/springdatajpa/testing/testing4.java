package com.ccdev.springdatajpa.testing;

import com.ccdev.springdatajpa.entities.entity4.Car;
import com.ccdev.springdatajpa.entities.entity4.Owner;
import com.ccdev.springdatajpa.repositories.repository4.CarRepository;
import com.ccdev.springdatajpa.repositories.repository4.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class testing4 implements CommandLineRunner {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setName("Cristhian");

        Car car = new Car();
        car.setBrand("Toyota");
        car.setModel("Accord");

        owner.setCar(car);
        car.setOwner(owner);


        ownerRepository.save(owner);

        //Reading an owner
        Long ownerId = owner.getId();
        Owner ownerRead = ownerRepository.findById(ownerId).orElse(null);
        if(ownerRead != null){
            System.out.println("Owner read: "+ ownerRead.getName());
        }

        //Updating owner's car
        Car updateCar = owner.getCar();
        System.out.println("Current brand car: "+updateCar.getBrand());
        updateCar.setBrand("Mercedes");
        updateCar.setModel("A1");

        //Deleting owner
        ownerRepository.deleteById(ownerId);


        //Delete verification
        Owner ownerDeleted = ownerRepository.findById(ownerId).orElse(null);
        if (ownerDeleted == null ){
            System.out.println("The owner has been deleted successfully");
        }
    }
}
