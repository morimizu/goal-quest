package com.benjaminrperry.goalquest.taskservice.service;

import com.benjaminrperry.goalquest.taskservice.api.messaging.CreateTaskMessage;
import com.benjaminrperry.goalquest.taskservice.api.messaging.UpdateTaskMessage;
import com.benjaminrperry.goalquest.taskservice.entity.task.Task;
import com.benjaminrperry.goalquest.taskservice.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.StringUtils.hasLength;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(CreateTaskMessage createTaskMessage){
        return taskRepository.createTask(
                createTaskMessage.getGoalId(),
                createTaskMessage.getDescription(),
                createTaskMessage.getOrderIndex()
        );
    }

    public Task updateTask(UpdateTaskMessage updateTaskMessage) {
        Task task = taskRepository.findTaskById(updateTaskMessage.getTaskId());
        if (hasLength(updateTaskMessage.getDescription())) {
            task.setDescription(updateTaskMessage.getDescription());
        }
        if (updateTaskMessage.getOrderIndex() != null) {
            task.setOrderIndex(updateTaskMessage.getOrderIndex());
        }
        return task;
    }

    public void deleteTask(Long taskId) {
        taskRepository.delete(taskId);
    }

    public void completeTask(Long taskId) {
        Task task = taskRepository.findTaskById(taskId);
        task.setComplete(true);
    }
}
