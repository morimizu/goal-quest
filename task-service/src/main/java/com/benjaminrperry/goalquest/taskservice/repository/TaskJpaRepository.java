package com.benjaminrperry.goalquest.taskservice.repository;

import com.benjaminrperry.goalquest.taskservice.entity.task.TaskJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskJpaRepository extends JpaRepository<TaskJpa, Long> {
}
