package com.benjaminrperry.goalquest.goalservice.service;

import com.benjaminrperry.goalquest.api.task.Task;
import com.benjaminrperry.goalquest.api.task.dto.CreateTaskDto;
import com.benjaminrperry.goalquest.goalservice.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(String description, LocalDate dueDate){
        log.info("creating new task");
        return taskRepository.createTask(
                description,
                dueDate
        );
    }

    public Task getTaskById(Long taskId) {
        log.info("getting task by id");
       return taskRepository.findTaskById(taskId);
    }

    public List<Task> getTaskList() {
        log.info("loading task list");
       return taskRepository.getTaskList();
    }


    public void deleteTask(Long taskId) {
        taskRepository.delete(taskId);
    }

    public Task completeTask(Long taskId) {
        Task task = taskRepository.findTaskById(taskId);
        task.complete();
        return task;
    }
}
