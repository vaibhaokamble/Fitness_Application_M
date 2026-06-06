package com.vaibhao.fitness.activityservice.Repository;

import com.vaibhao.fitness.activityservice.Model.ActivityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface ActivityRepository extends JpaRepository<ActivityModel,Long> {
}
