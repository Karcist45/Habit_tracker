package com.barbirms.infrastructure.repositories;

import com.barbirms.infrastructure.entities.Habit;
import com.barbirms.infrastructure.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Integer> {
    List<Habit> findAllByOwner(User owner);

    List<Habit> findAllByOwnerAndName(User owner, String name);
}
