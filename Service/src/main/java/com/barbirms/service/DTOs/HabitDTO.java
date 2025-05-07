package com.barbirms.service.DTOs;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.entities.HabitRecord;
import com.barbirms.infrastructure.entities.User;

import java.util.List;

public class HabitDTO {
    public Long id;
    public String name;
    public String description;
    public User owner;
    public List<HabitRecord> records;

    public HabitDTO(Habit habit) {
        id = habit.getId();
        name = habit.getName();
        description = habit.getDescription();
        owner = habit.getOwner();
        records = habit.getRecords();
    }
}
