package com.example.basicschedule.repository;

import com.example.basicschedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}

// 인터페이스는 원래 구현체가 없는