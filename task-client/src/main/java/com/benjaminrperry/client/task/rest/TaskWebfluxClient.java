package com.benjaminrperry.client.task.rest;

import com.benjaminrperry.client.task.TaskClient;
import com.benjaminrperry.client.task.configuration.TaskClientUrlProperties;
import com.benjaminrperry.goalquest.api.task.Task;
import com.benjaminrperry.goalquest.api.task.dto.CreateTaskDTO;
import com.benjaminrperry.goalquest.api.task.dto.UpdateTaskDTO;
import com.benjaminrperry.goalquest.api.task.messaging.GetTaskMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TaskWebfluxClient{

    private final WebClient webClient;

    private final TaskClientUrlProperties clientUrlProperties;


    private Map<String, String> urls(){
        return clientUrlProperties.getClient().get("task").getUrls();
    }

    private URI getUri(String name){
       return createUri(urls().get(name));
    }

    private URI createUri(String url) {
        return URI.create(url);
    }

    private URI getUriWithValues(String name, String placeholder, String value) {
        return createUri(urls().get(name).replace(placeholder, value));
    }


    public Mono<Task> createTask(Long goalId, String description, Integer orderIndex) {
        var body = CreateTaskDTO.builder()
                .goalId(goalId)
                .description(description)
                .orderIndex(orderIndex)
                .build();
        return webClient.post()
                .uri(createTaskUri())
                .bodyValue(body)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(Task.class);
    }

    public Mono<Task> updateTask(Long taskId, String description, Integer orderIndex) {
        var body = UpdateTaskDTO.builder()
                .description(description)
                .orderIndex(orderIndex)
                .build();
        return webClient.patch()
                .uri(updateTaskUri(taskId.toString()))
                .bodyValue(body)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(Task.class);
    }

    public Mono<Task> getTask(Long taskId) {
       return webClient.get()
                .uri(getTaskUri())
                .retrieve()
                .bodyToMono(Task.class);
    }

    public Mono<Task> completeTask(Long taskId) {
        return webClient.patch()
                .uri(completeTaskUri())
                .retrieve().bodyToMono(Task.class);
    }


    public Flux<Task> getAllTasks() {
        return webClient
                .get()
                .uri(getAllTaskUri())
                .retrieve()
                .bodyToFlux(Task.class);
    }

    private URI getAllTaskUri() {
        return getUri("base");
    }
    private URI createTaskUri() {
       return getUri("create");
    }

    private URI updateTaskUri(String taskId) {
        return getUriWithValues("update","{taskId}", taskId);
    }

    private URI getTaskUri() {
        return getUri("get");
    }

    private URI completeTaskUri() {
        return getUri("complete");
    }
}
