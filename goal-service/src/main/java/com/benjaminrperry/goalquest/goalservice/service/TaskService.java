package com.benjaminrperry.goalquest.goalservice.service;

import com.benjaminrperry.goalquest.api.goal.Step;
import com.benjaminrperry.goalquest.api.task.Task;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import com.benjaminrperry.goalquest.goalservice.repository.TaskRepository;

import java.util.List;

import static org.springframework.util.StringUtils.hasLength;

@Service
@Transactional
@DependsOn("stepListener")
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTaskFromStep(Step step){
        return taskRepository.createTask(
                step.getId(),
                step.getDescription()
        );
    }

    public Task getTaskById(Long taskId) {
       return taskRepository.findTaskById(taskId);
    }

    public List<Task> getTaskList() {
       return taskRepository.getTaskList();
    }


    public void deleteTask(Long taskId) {
        taskRepository.delete(taskId);
    }

    public void completeTask(Long taskId) {
        Task task = taskRepository.findTaskById(taskId);
        task.complete();
    }
}
