package com.barbirms.service.DTOs;

public record HabitStatsDTO(
        long totalDays,
        long completedDays,
        long currentStreak,
        long longestStreak
) {}
