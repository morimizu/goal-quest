package com.benjaminrperry.goalquest.goalservice.repository;

import com.benjaminrperry.goalquest.goalservice.entity.GoalJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<GoalJpa,Integer> {
}
