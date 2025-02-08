package com.example.basicschedule.controller;

import com.example.basicschedule.dto.ScheduleRequestDto;
import com.example.basicschedule.dto.ScheduleResponseDto;
import com.example.basicschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ScheduleResponseDto save(@RequestBody ScheduleRequestDto dto) {
        return scheduleService.save(dto);
    }

    @GetMapping("/schedules")
    public List<ScheduleResponseDto> findAll() {
        return scheduleService.findAll();
    }

    @GetMapping("/schedules/{id}")
    public ScheduleResponseDto findOne(@PathVariable Long id) {
        return scheduleService.findById(id);
    }

    @PutMapping("/schedules/{id}")
    public ScheduleResponseDto update(@PathVariable Long id, @RequestBody ScheduleRequestDto dto) {
        return scheduleService.update(id, dto);
    }

    @DeleteMapping("/schedules/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.deleteById(id);

    }


}
