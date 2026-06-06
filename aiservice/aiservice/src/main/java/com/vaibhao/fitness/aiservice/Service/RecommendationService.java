package com.vaibhao.fitness.aiservice.Service;

import com.vaibhao.fitness.aiservice.Model.RecommendationModel;
import com.vaibhao.fitness.aiservice.Repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class RecommendationService {

    private  final RecommendationRepository recommendationRepository;

    public List<RecommendationModel> getUserRecommendations(Long userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public List<RecommendationModel> getActivityRecommendations(Long activityId) {
        return Collections.singletonList(recommendationRepository.findByActivityId(activityId)
                .orElseThrow(() -> new RuntimeException("No recommendation found this activity " + activityId)));
    }
}
