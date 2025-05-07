package com.barbirms.service.interfaces;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.service.DTOs.HabitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HabitService {
    public void createHabit(String name, String description, String owner);

    public List<HabitDTO> getHabitsByUsername(String username);

    public void deleteHabit(String username, String habitName);

    public void RegisterHabit(String habitName, String habitOwner);
}
