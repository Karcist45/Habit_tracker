package com.barbirms.service.interfaces;

import com.barbirms.service.DTOs.HabitRecordDTO;
import com.barbirms.service.DTOs.HabitStatsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HabitRecordService {
    void RegisterHabit(String habitName, String habitOwner);

    List<HabitRecordDTO> getHabitRecords(String username, String habitName);

    HabitStatsDTO getHabitStats(String username, String habitName);
}
