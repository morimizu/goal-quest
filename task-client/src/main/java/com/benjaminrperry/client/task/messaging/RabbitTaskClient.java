package com.benjaminrperry.client.task.messaging;


import com.benjaminrperry.client.task.TaskClient;
import com.benjaminrperry.goalquest.api.task.Task;
import com.benjaminrperry.goalquest.api.task.messaging.CompleteTaskMessage;
import com.benjaminrperry.goalquest.api.task.messaging.CreateTaskMessage;
import com.benjaminrperry.goalquest.api.task.messaging.GetAllTaskMessage;
import com.benjaminrperry.goalquest.api.task.messaging.GetTaskMessage;
import com.benjaminrperry.messaging.RabbitSender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RabbitTaskClient implements TaskClient {

    private final RabbitSender sender;

    @Value("${goalquest.rabbit.exchange-name}")
    private String exchangeName;

    @Value("${goalquest.rabbit.bindings.task.routing-key}")
    private String routingKey;


    @Override
    public Task createTask(Long goalId, String description, Integer orderIndex) {
        CreateTaskMessage message = CreateTaskMessage.builder()
                .goalId(goalId)
                .description(description)
                .orderIndex(orderIndex)
                .build();
        return (Task) sender.sendAndReceive(exchangeName, routingKey, message);
    }

    @Override
    public Task getTask(Long taskId) {
        GetTaskMessage message = GetTaskMessage.builder().taskId(taskId).build();
        return (Task) sender.sendAndReceive(exchangeName, routingKey, message);
    }

    @Override
    public Task completeTask(Long taskId) {
        CompleteTaskMessage message = CompleteTaskMessage.builder().taskId(taskId).build();
        return (Task) sender.sendAndReceive(exchangeName, routingKey, message);
    }

    @Override
    public List<Task> getAllTasks() {
        GetAllTaskMessage message = GetAllTaskMessage.builder().build();
        return (List<Task>) sender.sendAndReceive(exchangeName, routingKey, message);
    }
}
