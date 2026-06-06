package com.vaibhao.fitness.activityservice.DTO.Request;

import com.vaibhao.fitness.activityservice.Enums.ActivityType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ActivityRequest {
    private Long userId;
    private ActivityType activityType;
    private Integer duration;
    private Integer calories;
    private LocalDateTime startTime;
    private Map<String, Object> additionalMetrics;

}
