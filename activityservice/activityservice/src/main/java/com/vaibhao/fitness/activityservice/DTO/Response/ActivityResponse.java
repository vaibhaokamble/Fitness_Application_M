package com.vaibhao.fitness.activityservice.DTO.Response;

import com.vaibhao.fitness.activityservice.Enums.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityResponse {
    private Long id;
    private Long userId;
    private ActivityType activityType;
    private Integer duration;
    private Integer calories;
    private LocalDateTime startTime;
    private Map<String, Object> additionalMetrics;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
