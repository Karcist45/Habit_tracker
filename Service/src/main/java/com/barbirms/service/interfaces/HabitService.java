package com.barbirms.service.interfaces;

import com.barbirms.service.DTOs.HabitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HabitService {
    void createHabit(String name, String description, String owner);

    List<HabitDTO> getHabitsByUsername(String username);

    void deleteHabit(String username, String habitName);
}
