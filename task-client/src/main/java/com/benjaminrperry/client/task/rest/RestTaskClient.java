package com.benjaminrperry.client.task.rest;

import com.benjaminrperry.client.task.TaskClient;
import com.benjaminrperry.goalquest.api.task.Task;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class RestTaskClient implements TaskClient {

    private final TaskWebfluxClient taskWebfluxClient;

    @Override
    public Task createTask(Long goalId, String description, Integer orderIndex) {
        return taskWebfluxClient.createTask(goalId,description,orderIndex).block();
    }

    @Override
    public Task getTask(Long taskId) {
        return taskWebfluxClient.getTask(taskId).block();
    }

    @Override
    public Task completeTask(Long taskId) {
        return taskWebfluxClient.completeTask(taskId).block();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskWebfluxClient.getAllTasks().collectList().block();
    }
}
