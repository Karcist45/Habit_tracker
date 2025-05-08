package com.barbirms.service.interfaces;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.entities.HabitRecord;
import com.barbirms.service.DTOs.HabitDTO;
import com.barbirms.service.DTOs.HabitRecordDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HabitService {
    void createHabit(String name, String description, String owner);

    List<HabitDTO> getHabitsByUsername(String username);

    void deleteHabit(String username, String habitName);
}
