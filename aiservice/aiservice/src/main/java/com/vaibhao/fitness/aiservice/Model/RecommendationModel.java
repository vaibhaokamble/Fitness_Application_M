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
@Table(name = "recommendations")
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
