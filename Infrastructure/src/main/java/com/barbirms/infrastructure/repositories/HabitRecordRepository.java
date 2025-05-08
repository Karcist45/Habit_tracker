package com.barbirms.infrastructure.repositories;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.entities.HabitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface HabitRecordRepository extends JpaRepository<HabitRecord, Integer> {
    List<HabitRecord> findAllByHabit(Habit habit);

    List<HabitRecord> findAllByHabitOrderByTimestampAsc(Habit habit);

    boolean existsByHabitIdAndTimestampBetween(Long id, Timestamp startTs, Timestamp endTs);
}