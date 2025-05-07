package com.barbirms.service.DTOs;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.entities.User;


import java.util.List;

public class UserDTO {
    public Long id;
    public String username;
    public int password;
    public List<Habit> habits;

    public UserDTO(User user) {
        id = user.getId();
        username = user.getUsername();
        password = user.getPassword();
        habits = user.getHabits();
    }
}
