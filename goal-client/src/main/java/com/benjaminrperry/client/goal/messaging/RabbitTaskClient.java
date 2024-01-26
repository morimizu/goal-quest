package com.benjaminrperry.client.goal.messaging;


import com.benjaminrperry.goalquest.api.task.dto.CreateTaskDto;
import com.benjaminrperry.goalquest.api.task.dto.TaskDTO;
import com.benjaminrperry.goalquest.api.task.messaging.CompleteTaskMessage;
import com.benjaminrperry.goalquest.api.task.messaging.GetTaskListMessage;
import com.benjaminrperry.goalquest.api.task.messaging.GetTaskMessage;
import com.benjaminrperry.messaging.RabbitSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.benjaminrperry.goalquest.api.task.converter.TaskConverter.toMessage;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitTaskClient {

    private final RabbitSender sender;

    @Value("${goalquest.rabbit.exchange-name}")
    private String exchangeName;

    @Value("${goalquest.rabbit.bindings.task.routing-key}")
    private String routingKey;

    public TaskDTO createTask(CreateTaskDto createTaskDTO){
        log.info("received CreateTaskDTO request with data:" + createTaskDTO.toString());
        var createTask = toMessage(createTaskDTO);
        log.info("sending CreateTaskMessage: " + createTask.toString());
        return (TaskDTO) sender.sendAndReceive(exchangeName, routingKey, createTask);
    }

    public TaskDTO getTask(Long taskId) {
        var getTask = GetTaskMessage.builder().taskId(taskId).build();
        return (TaskDTO) sender.sendAndReceive(exchangeName, routingKey, getTask);
    }

    public TaskDTO completeTask(Long taskId) {
        var completeTask = CompleteTaskMessage.builder().taskId(taskId);
        return (TaskDTO) sender.sendAndReceive(exchangeName, routingKey, completeTask);
    }

    public List<TaskDTO> getTaskList() {
        log.info("sending GetTaskListMessage");
        return (List<TaskDTO>) sender.sendAndReceive(exchangeName, routingKey, GetTaskListMessage.builder().build());
    }
}
