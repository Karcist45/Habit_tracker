package com.barbirms.infrastructure.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Habit {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL)
    private List<HabitRecord> records;
}