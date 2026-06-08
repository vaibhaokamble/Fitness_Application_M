package com.vaibhao.fitness.aiservice.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.RowId;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "recommendations", indexes = {
    // ⚡ Bolt: Adding indexes for frequently queried fields to improve read performance
    @Index(name = "idx_activity_id", columnList = "activityId"),
    @Index(name = "idx_user_id", columnList = "userId")
})
@Builder
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
