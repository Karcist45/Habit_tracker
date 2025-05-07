package com.barbirms.presentation.controllers;

import com.barbirms.service.DTOs.HabitDTO;
import com.barbirms.service.interfaces.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HabitController {
    @Autowired
    private HabitService habitService;

    @PostMapping("user/{habitOwner}/habits/{habitName}/{habitDescription}")
    public void CreateHabit(@PathVariable String habitName,
                            @PathVariable String habitDescription,
                            @PathVariable String habitOwner) {
        habitService.createHabit(habitName, habitDescription, habitOwner);
    }

    @GetMapping("user/{habitOwner}/habits")
    public List<HabitDTO> getHabitsByUsername(@PathVariable String habitOwner) {
        return habitService.getHabitsByUsername(habitOwner);
    }

    @DeleteMapping("user/{habitOwner}/habits/{habitName}")
    public void deleteHabit(@PathVariable String habitOwner, @PathVariable String habitName) {
        habitService.deleteHabit(habitOwner, habitName);
    }
}