package com.ccdev.springdatajpa.entities.entity6;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String destination;
    private String flight_number;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
}
