package com.benjaminrperry.goalservice.api;

import com.benjaminrperry.goalservice.dto.CreateGoalDTO;
import com.benjaminrperry.goalservice.dto.GoalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
public class RestGoalClient implements GoalClient {
    private final RestTemplate restTemplate;

    @Override
    public Goal createGoal(String description) {
        var createGoalDto = CreateGoalDTO.builder().description(description).build();
        return restTemplate.postForObject("http://loaclhost:8080/goal",createGoalDto,GoalDTO.class);
    }

    @Override
    public Goal getGoal(Integer goalId) {
        return restTemplate.getForObject("http://loaclhost:8080/goal/"+ goalId, GoalDTO.class);
    }

    @Override
    public Goal completeGoal(Integer goalId) {
        return null;
    }

    @Override
    public List<Goal> getAllGoals() {
        return (List<Goal>) restTemplate.getForObject("http://loaclhost:8080/goal", List.class);
    }
}
