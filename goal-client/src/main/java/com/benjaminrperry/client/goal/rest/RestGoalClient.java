package com.benjaminrperry.client.goal.rest;

import com.benjaminrperry.client.goal.Goal;
import com.benjaminrperry.client.goal.GoalClient;
import com.benjaminrperry.client.goal.configuration.ClientUrlProperties;
import com.benjaminrperry.client.goal.dto.CreateGoalDTO;
import com.benjaminrperry.client.goal.dto.GoalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class RestGoalClient implements GoalClient {

    private final RestTemplate restTemplate;

    private final ClientUrlProperties clientUrlProperties;

    @Override
    public Goal createGoal(String description) {
        var createGoalDto = CreateGoalDTO.builder().description(description).build();
        return restTemplate.postForObject(getUri("create"), createGoalDto, GoalDTO.class);
    }

    @Override
    public Goal getGoal(Integer goalId) {
        return restTemplate.getForObject(URI.create(urls().get("get").replace("{id}", goalId.toString())), GoalDTO.class);
    }

    @Override
    public Goal completeGoal(Integer goalId) {
        return null;
    }

    @Override
    public List<Goal> getAllGoals() {
        return restTemplate.getForObject(getUri("base"), List.class);
    }

    private Map<String, String> urls(){
        return clientUrlProperties.getClient().get("goal").getUrls();
    }

    private URI getUri(String name){
       return URI.create(urls().get(name));
    }
}
