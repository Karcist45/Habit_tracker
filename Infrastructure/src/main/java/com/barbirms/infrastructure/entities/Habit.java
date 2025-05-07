package com.barbirms.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private User owner;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<HabitRecord> records;

    public Habit() {}

    public Habit(String name, String description, User owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public User getOwner(){
        return owner;
    }

    public List<HabitRecord> getRecords(){
        return records;
    }
}
