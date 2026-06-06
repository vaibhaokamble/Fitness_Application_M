package com.vaibhao.fitness.aiservice.Repository;

import com.vaibhao.fitness.aiservice.Model.RecommendationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationModel,Long> {
    Optional<RecommendationModel> findByActivityId(Long activityId);

    List<RecommendationModel> findByUserId(Long userId);
}
