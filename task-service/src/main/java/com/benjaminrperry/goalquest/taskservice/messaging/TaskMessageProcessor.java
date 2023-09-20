package com.benjaminrperry.goalquest.taskservice.messaging;

import com.benjaminrperry.goalquest.api.task.Task;
import com.benjaminrperry.goalquest.api.task.messaging.CreateTaskMessage;
import com.benjaminrperry.goalquest.api.task.messaging.DeleteTaskMessage;
import com.benjaminrperry.goalquest.api.task.messaging.UpdateTaskMessage;
import com.benjaminrperry.goalquest.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@RabbitListener(queues = "${goalquest.rabbit.bindings.task.queue-name}")
public class TaskMessageProcessor {

    private final TaskService taskService;

    @RabbitHandler
    public Task processCreateTask(@Payload CreateTaskMessage createTaskMessage) {
        return taskService.createTask(createTaskMessage);
    }

    @RabbitHandler
    public Task processUpdateTask(@Payload UpdateTaskMessage updateTaskMessage) {
        return taskService.updateTask(updateTaskMessage);
    }

    @RabbitHandler
    public void processDeleteTask(@Payload DeleteTaskMessage deleteTaskMessage) {
        taskService.deleteTask(deleteTaskMessage.getTaskId());
    }
}
