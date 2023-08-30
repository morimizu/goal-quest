package com.benjaminrperry.goalservice.repository;

import com.benjaminrperry.goalservice.api.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Integer> {
}
