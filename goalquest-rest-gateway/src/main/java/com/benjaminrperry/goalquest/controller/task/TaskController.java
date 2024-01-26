package com.benjaminrperry.goalquest.controller.task;


import com.benjaminrperry.client.goal.messaging.RabbitTaskClient;
import com.benjaminrperry.goalquest.api.task.dto.CreateTaskDto;
import com.benjaminrperry.goalquest.api.task.dto.TaskDTO;
import com.benjaminrperry.goalquest.api.task.dto.UpdateTaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/task")
@CrossOrigin
@RequiredArgsConstructor
public class TaskController {
    private final RabbitTaskClient rabbitTaskClient;

    @PostMapping
    @ResponseStatus(CREATED)
    public TaskDTO createTask(@RequestBody CreateTaskDto createTaskDTO) {
       return rabbitTaskClient.createTask(createTaskDTO);
    }

    @PatchMapping("/{taskId}")
    public @ResponseBody TaskDTO updateTask(@PathVariable(name = "taskId") Long taskId, @RequestAttribute UpdateTaskDTO updateTaskDTO) {
        return null;
    }

    @PatchMapping("/{taskId}/complete")
    public @ResponseBody TaskDTO completeTask(@PathVariable(name = "taskId") Long taskId) {
        return rabbitTaskClient.completeTask(taskId);
    }

    @GetMapping("/{taskId}")
    public @ResponseBody TaskDTO getTask(@PathVariable(name = "taskId") Long taskId) {
        return rabbitTaskClient.getTask(taskId);
    }

    @GetMapping
    public @ResponseBody List<TaskDTO> getAllTasks() {
        return rabbitTaskClient.getTaskList().stream()
                .toList();
    }

}
