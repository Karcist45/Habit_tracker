package com.barbirms.service.implementations;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.entities.HabitRecord;
import com.barbirms.infrastructure.entities.User;
import com.barbirms.infrastructure.repositories.HabitRecordRepository;
import com.barbirms.infrastructure.repositories.HabitRepository;
import com.barbirms.infrastructure.repositories.UserRepository;
import com.barbirms.service.DTOs.HabitRecordDTO;
import com.barbirms.service.DTOs.HabitStatsDTO;
import com.barbirms.service.interfaces.HabitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HabitRecordServiceImpl implements HabitRecordService {
    @Autowired
    private HabitRecordRepository _habitRecordRepository;

    @Autowired
    private HabitRepository _habitRepository;

    @Autowired
    private UserRepository _userRepository;

    @Override
    public void RegisterHabit(String habitName, String habitOwner) {
        User habitOwnerUser = _userRepository.getUserByUsername(habitOwner);
        _habitRecordRepository.save(new HabitRecord(_habitRepository.
                findAllByOwnerAndName(habitOwnerUser, habitName).getFirst()));
    }

    @Override
    public List<HabitRecordDTO> getHabitRecords(String username, String habitName) {
        Habit habit = _habitRepository.
                findAllByOwnerAndName(_userRepository.getUserByUsername(username), habitName).getFirst();
        return _habitRecordRepository.findAllByHabit(habit).
                stream().map(this::HabitRecordToDTO).collect(Collectors.toList());
    }

    @Override
    public HabitStatsDTO getHabitStats(String username, String habitName) {
        Habit habit = _habitRepository.
                findAllByOwnerAndName(_userRepository.getUserByUsername(username), habitName).getFirst();

        List<LocalDate> completedDates = _habitRecordRepository
                .findAllByHabitOrderByTimestampAsc(habit)
                .stream()
                .map(record -> record.getTimestamp().toLocalDateTime().toLocalDate())
                .distinct()
                .sorted()
                .toList();

        if (completedDates.isEmpty()) {
            return new HabitStatsDTO(0, 0, 0, 0);
        }

        long completedDays = completedDates.size();
        long totalDays = ChronoUnit.DAYS.between(completedDates.getFirst(), LocalDate.now()) + 1;

        long currentStreak = 0;
        long longestStreak = 0;
        long tempStreak = 0;
        LocalDate previous = null;

        for (LocalDate date : completedDates) {
            if (previous == null || date.equals(previous.plusDays(1))) {
                tempStreak++;
            } else {
                tempStreak = 1;
            }
            longestStreak = Math.max(longestStreak, tempStreak);
            previous = date;
        }

        if (previous != null && previous.equals(LocalDate.now())) {
            currentStreak = tempStreak;
        }

        return new HabitStatsDTO(totalDays, completedDays, currentStreak, longestStreak);
    }

    private HabitRecordDTO HabitRecordToDTO (HabitRecord habitRecord) {
        return new HabitRecordDTO(habitRecord);
    }
}
