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

    public Task createTask(Long stepId, String description) {
        TaskJpa newTask = TaskJpa.builder()
                .stepId(stepId)
                .description(description)
                .build();
        return taskJpaRepository.save(newTask);
    }

    public List<Task> getTasksForStep(Long stepId) {
       return taskJpaRepository.findAll(buildExample(stepId)).stream()
               .map(this::toTask)
               .toList();
    }

    public Task findTaskById(Long taskId) {
        return taskJpaRepository.findById(taskId)
                .orElseThrow(this::throwNotFound);
    }

    public List<Task> getTaskList() {
       return taskJpaRepository.findAllByCompletedFalse().stream()
               .map(task -> (Task) task)
               .toList();
    }

    public void delete(Long taskId) {
        taskJpaRepository.deleteById(taskId);
    }

    private EntityNotFoundException throwNotFound() {
       return new EntityNotFoundException("No Task found by that id");
    }

    private Example<TaskJpa> buildExample(Long stepId) {
        return Example.of(TaskJpa.builder().stepId(stepId).build());
    }
    private Task toTask(TaskJpa jpa){
        return jpa;
    }
}
