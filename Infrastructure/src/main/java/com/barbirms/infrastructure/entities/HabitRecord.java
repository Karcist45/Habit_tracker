package com.barbirms.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.sql.Timestamp;

@Entity
public class HabitRecord {
    @Id
    @GeneratedValue
    private Long id;

    private Timestamp timestamp;

    @ManyToOne
    @JsonBackReference
    private Habit habit;
}
