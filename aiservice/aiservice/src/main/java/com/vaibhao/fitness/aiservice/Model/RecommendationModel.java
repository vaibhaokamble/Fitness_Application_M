package com.vaibhao.fitness.aiservice.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(
    name = "recommendations",
    indexes = {
        @Index(name = "idx_recommendation_user_id", columnList = "userId"),
        @Index(name = "idx_recommendation_activity_id", columnList = "activityId")
    }
)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  Long activityId;
    private  Long userId;
    private  String recommendations;
    private List<String> suggestions;
    private List<String> safety;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
