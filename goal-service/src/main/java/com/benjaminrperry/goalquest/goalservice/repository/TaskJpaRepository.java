package com.benjaminrperry.goalquest.goalservice.repository;


import com.benjaminrperry.goalquest.goalservice.entity.task.TaskJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskJpaRepository extends JpaRepository<TaskJpa, Long> {
    TaskJpa findByStepId(Long stepId);
    List<TaskJpa> findAllByCompletedFalse();
    List<TaskJpa> findAllByCompletedTrue();
}
