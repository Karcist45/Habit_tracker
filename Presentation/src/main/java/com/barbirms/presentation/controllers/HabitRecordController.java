package com.barbirms.presentation.controllers;

import com.barbirms.service.DTOs.HabitRecordDTO;
import com.barbirms.service.DTOs.HabitStatsDTO;
import com.barbirms.service.interfaces.HabitRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HabitRecordController {
    @Autowired
    HabitRecordService habitRecordService;

    @PostMapping("user/{habitOwner}/habit/{habitName}/records")
    public void RegisterHabit(@PathVariable String habitName, @PathVariable String habitOwner) {
        habitRecordService.RegisterHabit(habitName, habitOwner);
    }

    @GetMapping("/fake-get/user/{habitOwner}/habit/{habitName}/records")
    public void FakeGetRegisterHabit(@PathVariable String habitName, @PathVariable String habitOwner) {
        habitRecordService.RegisterHabit(habitName, habitOwner);
    }

    @GetMapping("user/{habitOwner}/habit/{habitName}/records")
    public List<HabitRecordDTO> getHabitRecords(@PathVariable String habitOwner, @PathVariable String habitName) {
        return habitRecordService.getHabitRecords(habitOwner, habitName);
    }

    @GetMapping("user/{habitOwner}/habit/{habitName}/records/stats")
    public HabitStatsDTO getHabitStats(@PathVariable String habitOwner, @PathVariable String habitName) {
        return habitRecordService.getHabitStats(habitOwner, habitName);
    }

}
