package com.barbirms.service.implementations;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.entities.HabitRecord;
import com.barbirms.infrastructure.entities.User;
import com.barbirms.infrastructure.repositories.HabitRecordRepository;
import com.barbirms.infrastructure.repositories.HabitRepository;
import com.barbirms.infrastructure.repositories.UserRepository;
import com.barbirms.service.DTOs.HabitDTO;
import com.barbirms.service.DTOs.HabitRecordDTO;
import com.barbirms.service.DTOs.UserDTO;
import com.barbirms.service.interfaces.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitServiceImpl implements HabitService {
    @Autowired
    private HabitRepository _habitRepository;

    @Autowired
    private UserRepository _userRepository;

    @Override
    public void createHabit(String name, String description, String owner) {
        _habitRepository.save(new Habit(name, description, _userRepository.getUserByUsername(owner)));
    }

    @Override
    public List<HabitDTO> getHabitsByUsername(String username) {
        return _habitRepository.findAllByOwner(_userRepository.getUserByUsername(username)).
                stream().map(this::HabitToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteHabit(String username, String habitName) {
        _habitRepository.deleteAll(_habitRepository.
                findAllByOwnerAndName(_userRepository.getUserByUsername(username), habitName));
    }

    private HabitDTO HabitToDTO (Habit habit) {
        return new HabitDTO(habit);
    }
}
