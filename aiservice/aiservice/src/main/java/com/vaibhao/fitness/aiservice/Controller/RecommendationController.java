package com.vaibhao.fitness.aiservice.Controller;

import com.vaibhao.fitness.aiservice.Model.RecommendationModel;
import com.vaibhao.fitness.aiservice.Service.RecommendationService;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationModel>> getUserRecommendations(@PathVariable Long userId){
        return  ResponseEntity.ok(recommendationService.getUserRecommendations(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<List<RecommendationModel>> getActivityRecommendations(@PathVariable Long activityId){
        return ResponseEntity.ok(recommendationService.getActivityRecommendations(activityId));
    }
}
