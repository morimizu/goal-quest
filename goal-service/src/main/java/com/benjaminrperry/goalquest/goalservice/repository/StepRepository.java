package com.benjaminrperry.goalquest.goalservice.repository;

import com.benjaminrperry.goalquest.goalservice.entity.StepJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StepRepository extends JpaRepository<StepJpa, Long> {
}
