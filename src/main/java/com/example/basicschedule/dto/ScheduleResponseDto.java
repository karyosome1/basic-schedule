package com.example.basicschedule.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;
    private final String content;

    public ScheduleResponseDto(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
