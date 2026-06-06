package com.vaibhao.fitness.activityservice.Service;

import com.vaibhao.fitness.activityservice.DTO.Request.ActivityRequest;
import com.vaibhao.fitness.activityservice.DTO.Response.ActivityResponse;
import com.vaibhao.fitness.activityservice.Model.ActivityModel;
import com.vaibhao.fitness.activityservice.Repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;

    private final UserValidationService userValidationService;

    public ActivityResponse trackActivity(ActivityRequest activityRequest) {

        boolean isValidUser = userValidationService.validateUser(String.valueOf(activityRequest.getUserId()));

        if (!isValidUser) {
            throw new RuntimeException("invalid user id" +activityRequest.getUserId());
        }

        ActivityModel activityModel =ActivityModel.builder()
                .userId(activityRequest.getUserId())
                .activityType(activityRequest.getActivityType())
                .duration(activityRequest.getDuration())
                .calories(activityRequest.getCalories())
                .startTime(activityRequest.getStartTime())
                .additionalMetrics(activityRequest.getAdditionalMetrics())
                .build();

        ActivityModel savedActivity = activityRepository.save(activityModel);
        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(ActivityModel activityModel) {
        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setId(activityModel.getId());
        activityResponse.setUserId(activityModel.getUserId());
        activityResponse.setActivityType(activityModel.getActivityType());
        activityResponse.setDuration(activityModel.getDuration());
        activityResponse.setCalories(activityModel.getCalories());
        activityResponse.setStartTime(activityModel.getStartTime());
        activityResponse.setAdditionalMetrics(activityModel.getAdditionalMetrics());
        activityResponse.setCreatedAt(activityModel.getCreatedAt());
        activityResponse.setUpdatedAt(activityModel.getUpdatedAt());

        return activityResponse;
    }
}
