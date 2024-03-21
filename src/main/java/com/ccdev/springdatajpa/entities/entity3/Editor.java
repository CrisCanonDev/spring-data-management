package com.ccdev.springdatajpa.entities.entity3;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Editor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "editor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Magazine> magazines = new ArrayList<>();

}
