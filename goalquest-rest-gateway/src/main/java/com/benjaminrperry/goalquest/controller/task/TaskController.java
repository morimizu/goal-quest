package com.benjaminrperry.goalquest.controller.task;

import com.benjaminrperry.client.task.messaging.RabbitTaskClient;
import com.benjaminrperry.goalquest.api.task.converter.TaskConverter;
import com.benjaminrperry.goalquest.api.task.dto.CreateTaskDTO;
import com.benjaminrperry.goalquest.api.task.dto.TaskDTO;
import com.benjaminrperry.goalquest.api.task.dto.UpdateTaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.benjaminrperry.goalquest.api.task.converter.TaskConverter.toDto;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
    private final RabbitTaskClient rabbitTaskClient;

    @PostMapping
    @ResponseStatus(CREATED)
    public TaskDTO createTask(CreateTaskDTO createTaskDTO) {
       return toDto(rabbitTaskClient.createTask(createTaskDTO.getGoalId(), createTaskDTO.getDescription(), createTaskDTO.getOrderIndex()));
    }

    @PatchMapping("/{taskId}")
    public @ResponseBody TaskDTO updateTask(@PathVariable(name = "taskId") Long taskId, @RequestAttribute UpdateTaskDTO updateTaskDTO) {
        return null;
    }

    @GetMapping("/{taskId}")
    public @ResponseBody TaskDTO getTask(@PathVariable(name = "taskId") Long taskId) {
        return toDto(rabbitTaskClient.getTask(taskId));
    }

    @GetMapping
    public @ResponseBody List<TaskDTO> getAllTasks() {
        return rabbitTaskClient.getAllTasks().stream()
                .map(TaskConverter::toDto)
                .toList();
    }

}
