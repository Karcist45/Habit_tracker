package com.barbirms.infrastructure.repositories;

import com.barbirms.infrastructure.entities.HabitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRecordRepository extends JpaRepository<HabitRecord, Integer> {
}