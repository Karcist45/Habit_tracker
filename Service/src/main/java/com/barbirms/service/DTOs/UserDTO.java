package com.barbirms.service.DTOs;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.entities.User;


import java.util.List;

public class UserDTO {
    public Long id;
    public String username;
    public String password;
    public List<Habit> habits;

    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.habits = user.getHabits();
    }
}
