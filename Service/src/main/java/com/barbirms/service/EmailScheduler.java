package com.barbirms.service;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.repositories.HabitRecordRepository;
import com.barbirms.infrastructure.repositories.HabitRepository;
import com.barbirms.service.implementations.HabitMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class EmailScheduler {
    @Autowired
    private HabitRepository _habitRepository;

    @Autowired
    private HabitRecordRepository _recordRepository;

    @Autowired
    private HabitMailService emailService;

    @Scheduled(cron = "* * 20 * * *")
    public void sendDailyReminders() {
        LocalDate yesterdayDate = LocalDate.now().minusDays(1);
        LocalDateTime startOfYesterday = yesterdayDate.atStartOfDay();
        LocalDateTime startOfToday   = yesterdayDate.plusDays(1).atStartOfDay();

        Timestamp startTs = Timestamp.valueOf(startOfYesterday);
        Timestamp endTs   = Timestamp.valueOf(startOfToday);

        List<Habit> habits = _habitRepository.findAll();
        for (Habit habit : habits) {
            boolean didRecord = _recordRepository
                    .existsByHabitIdAndTimestampBetween(habit.getId(), startTs, endTs);
            if (!didRecord) {
                emailService.sendReminder(habit.getOwner(), habit, yesterdayDate);
            }
        }
    }
}