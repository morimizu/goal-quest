package com.benjaminrperry.goalquest.controller.goal;

import com.benjaminrperry.client.goal.messaging.RabbitGoalClient;
import com.benjaminrperry.goalquest.api.goal.converter.GoalConverter;
import com.benjaminrperry.goalquest.api.goal.dto.CreateGoalDTO;
import com.benjaminrperry.goalquest.api.goal.dto.GoalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.benjaminrperry.goalquest.api.goal.converter.GoalConverter.toGoalDTO;
import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/goal")
@RequiredArgsConstructor
public class GoalController {

    private final RabbitGoalClient rabbitGoalClient;

    @GetMapping
    @ResponseStatus(OK)
    public @ResponseBody List<GoalDTO> getGoals(){
        var goals = rabbitGoalClient.getAllGoals();
        return goals.stream().map(GoalConverter::toGoalDTO).toList();
    }

    @GetMapping("/{goalId}")
    @ResponseStatus(OK)
    public @ResponseBody GoalDTO getGoal(@PathVariable(name = "goalId") Integer goalId){
        var goal = rabbitGoalClient.getGoal(goalId);
        return toGoalDTO(goal);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public @ResponseBody GoalDTO createGoal(@RequestBody CreateGoalDTO createGoalDTO){
        var goal = rabbitGoalClient.createGoal(createGoalDTO.getDescription());
        return toGoalDTO(goal);
    }

    @PatchMapping("/{goalId}/complete")
    @ResponseStatus(ACCEPTED)
    public @ResponseBody GoalDTO completeGoal(@PathVariable(name = "goalId") Integer goalId){
        var goal = rabbitGoalClient.completeGoal(goalId);
        return toGoalDTO(goal);
    }

}
