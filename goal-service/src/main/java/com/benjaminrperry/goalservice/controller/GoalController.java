package com.benjaminrperry.goalservice.controller;

import com.benjaminrperry.client.goal.messaging.RabbitGoalClient;
import com.benjaminrperry.client.goal.Goal;
import com.benjaminrperry.goalservice.converter.GoalConverter;
import com.benjaminrperry.client.goal.dto.CreateGoalDTO;
import com.benjaminrperry.client.goal.dto.GoalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.benjaminrperry.goalservice.converter.GoalConverter.toGoalDTO;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/goal")
@RequiredArgsConstructor
public class GoalController {

    private final RabbitGoalClient rabbitGoalClient;

    @PostMapping
    @ResponseStatus(CREATED)
    public GoalDTO createGoal(@RequestBody CreateGoalDTO createGoalDTO){
        var goal = rabbitGoalClient.createGoal(createGoalDTO.getDescription());
        return toGoalDTO(goal);
    }

    @PatchMapping("/{goalId}/complete")
    public GoalDTO completeGoal(@PathVariable Integer goalId){
        var goal = rabbitGoalClient.completeGoal(goalId);
        return toGoalDTO(goal);
    }

    @GetMapping
    public List<GoalDTO> getGoals(){
        var goals = rabbitGoalClient.getAllGoals();
        return goals.stream().map(GoalConverter::toGoalDTO).toList();
    }

    @GetMapping("/{goalId}")
    public GoalDTO getGoal(@PathVariable Integer goalId){
        var goal = rabbitGoalClient.getGoal(goalId);
        return toGoalDTO(goal);
    }




}
