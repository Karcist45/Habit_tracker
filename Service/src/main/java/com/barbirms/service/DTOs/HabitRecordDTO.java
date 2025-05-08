package com.barbirms.service.DTOs;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.entities.HabitRecord;

import java.sql.Timestamp;

public class HabitRecordDTO {
    public Long id;
    public Timestamp timestamp;
    public Habit habit;

    public HabitRecordDTO(HabitRecord habitRecord) {
        this.habit = habitRecord.getHabit();
        this.timestamp = habitRecord.getTimestamp();
        this.id = habitRecord.getId();
    }
}
