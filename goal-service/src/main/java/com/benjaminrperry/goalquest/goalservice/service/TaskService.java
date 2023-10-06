package com.benjaminrperry.goalquest.goalservice.service;

import com.benjaminrperry.goalquest.api.task.Task;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.benjaminrperry.goalquest.goalservice.repository.TaskRepository;

import static org.springframework.util.StringUtils.hasLength;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createTask(Long goalId, String description, Integer order){
        return taskRepository.createTask(
                goalId,
                description,
                order
        );
    }

//    public Task updateTask(UpdateTaskMessage updateTaskMessage) {
//        Task task = taskRepository.findTaskById(updateTaskMessage.getTaskId());
//        if (hasLength(updateTaskMessage.getDescription())) {
//            task.setDescription(updateTaskMessage.getDescription());
//        }
//        if (updateTaskMessage.getOrderIndex() != null) {
//            task.setOrderIndex(updateTaskMessage.getOrderIndex());
//        }
//        return task;
//    }

    public void deleteTask(Long taskId) {
        taskRepository.delete(taskId);
    }

    public void completeTask(Long taskId) {
        Task task = taskRepository.findTaskById(taskId);
        task.setComplete(true);
    }
}
