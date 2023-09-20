package com.benjaminrperry.client.task;



import com.benjaminrperry.goalquest.api.task.Task;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TaskClient {

    Task createTask(Long goalId, String description, Integer orderIndex);

    Task getTask(Long taskId);

    Task completeTask(Long taskId);

    List<Task> getAllTasks();
}
