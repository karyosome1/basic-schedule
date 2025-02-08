package com.example.basicschedule.service;

import com.example.basicschedule.dto.ScheduleRequestDto;
import com.example.basicschedule.dto.ScheduleResponseDto;
import com.example.basicschedule.entity.Schedule;
import com.example.basicschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto dto) {
        Schedule schedule = new Schedule(dto.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getContent());

    }
    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            ScheduleResponseDto dto = new ScheduleResponseDto(schedule.getId(), schedule.getContent());
            dtos.add(dto);
        }
        return dtos;

    }
    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없음")
        );
        return new ScheduleResponseDto(schedule.getId(), schedule.getContent());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("없음")
        );

        schedule.update(dto.getContent());
        return new ScheduleResponseDto(schedule.getId(), schedule.getContent());

    }

    @Transactional
    public void deleteById(Long id) {
        if (!scheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("없음");
        }
        scheduleRepository.deleteById(id);
    }
}
