package com.ccdev.springdatajpa.testing;


import com.ccdev.springdatajpa.entities.entity6.Airline;
import com.ccdev.springdatajpa.entities.entity6.Flight;
import com.ccdev.springdatajpa.repositories.repository6.AirlineRepository;
import com.ccdev.springdatajpa.repositories.repository6.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class testing6 implements CommandLineRunner {
    @Autowired
    private AirlineRepository airlineRepository;
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public void run(String... args) throws Exception {
        Airline airline = new Airline();
        airline.setName("Ryanair RYN");

        Flight flight1 = new Flight();
        flight1.setDestination("London");
        flight1.setFlight_number("RYN1234");

        Flight flight2 = new Flight();
        flight2.setDestination("Barcelona");
        flight2.setFlight_number("RYN987");

        airline.getFlights().add(flight1);
        airline.getFlights().add(flight2);

        airlineRepository.save(airline);

        //Read Airline from repository
        Airline airlineFromDB = airlineRepository.findById(airline.getId()).orElse(null);
        System.out.println("Airline -> "+airlineFromDB.getName());

        //Delete airline
        airlineRepository.delete(airlineFromDB);

        //Check that airline and flights (due to REMOVE cascade type) have been deleted
        List<Flight> flightList = flightRepository.findAll();
        System.out.println("Flights list size: "+flightList.size());

    }
}
