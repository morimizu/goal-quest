package com.benjaminrperry.goalquest.goalservice.repository;

import com.benjaminrperry.goalquest.api.task.Task;
import com.benjaminrperry.goalquest.goalservice.entity.task.TaskJpa;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepository {
    private final TaskJpaRepository taskJpaRepository;

    public Task createTask(Long goalId, String description, Integer order) {
        TaskJpa newTask = TaskJpa.builder()
                .goalId(goalId)
                .description(description)
                .orderIndex(order)
                .build();
        return taskJpaRepository.save(newTask);
    }

    public List<Task> getTasksForGoal(Long goalId) {
       return taskJpaRepository.findAll(buildExample(goalId)).stream()
               .map(this::toTask)
               .toList();
    }

    public Task findTaskById(Long taskId) {
        return taskJpaRepository.findById(taskId)
                .orElseThrow(this::throwNotFound);
    }

    public void delete(Long taskId) {
        taskJpaRepository.deleteById(taskId);
    }

    private EntityNotFoundException throwNotFound() {
       return new EntityNotFoundException("No Task found by that id");
    }

    private Example<TaskJpa> buildExample(Long goalId) {
        return Example.of(TaskJpa.builder().goalId(goalId).build());
    }
    private Task toTask(TaskJpa jpa){
        return jpa;
    }
}
