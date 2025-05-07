package com.barbirms.infrastructure.repositories;

import com.barbirms.infrastructure.entities.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Integer> {
}
