package com.benjaminrperry.goalquest.goalservice.messaging;

import com.benjaminrperry.goalquest.api.task.converter.TaskConverter;
import com.benjaminrperry.goalquest.api.task.dto.TaskDTO;
import com.benjaminrperry.goalquest.api.task.messaging.GetTaskListMessage;
import com.benjaminrperry.goalquest.api.task.messaging.GetTaskMessage;
import com.benjaminrperry.goalquest.goalservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@RabbitListener(queues = "${goalquest.rabbit.bindings.task.queue-name}")
@Component
@Slf4j
@RequiredArgsConstructor
public class TaskMessageProcessor {

    private final TaskService taskService;



    @RabbitHandler
    public Optional<TaskDTO> handelGetTask(@Payload GetTaskMessage getTaskMessage) {
        log.info("processing GetTaskMessage");
        return Optional.of(TaskConverter.toDto(taskService.getTaskById(getTaskMessage.getTaskId())));
    }

    @RabbitHandler
    public List<TaskDTO> handelGetTaskList(@Payload GetTaskListMessage getTaskListMessage) {
        log.info("processing GetTaskListMessage");
        return taskService.getTaskList().stream().map(TaskConverter::toDto).toList();
    }
}
