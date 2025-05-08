package com.barbirms.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class HabitRecord {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Timestamp timestamp;

    @ManyToOne
    @JsonBackReference
    private Habit habit;

    public HabitRecord() {};

    public HabitRecord(Habit habit) {
        this.habit = habit;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Habit getHabit() {
        return habit;
    }
}
