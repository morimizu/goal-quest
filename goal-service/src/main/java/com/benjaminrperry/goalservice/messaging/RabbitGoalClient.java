package com.benjaminrperry.goalservice.messaging;

import com.benjaminrperry.goalservice.api.Goal;
import com.benjaminrperry.goalservice.api.GoalClient;
import com.benjaminrperry.messaging.RabbitSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitGoalClient implements GoalClient {

    private final RabbitSender sender;

    @Override
    public Goal createGoal(String description) {
        log.info("creating new goal with descr: "+ description);
        var createGoal = CreateGoalMessage.builder().description(description).build();
        return (Goal) sender.sendAndReceive(createGoal);
    }

    @Override
    public Goal getGoal(Integer goalId) {
        var getGoal = GetGoalMessage.builder().goalId(goalId).build();
        return (Goal) sender.sendAndReceive(getGoal);
    }

    @Override
    public Goal completeGoal(Integer goalId) {
        var completeGoal = CompleteGoalMessage.builder().goalId(goalId).build();
        return (Goal) sender.sendAndReceive(completeGoal);
    }

    @Override
    public List<Goal> getAllGoals() {
        return (List<Goal>) sender.sendAndReceive(GetGoalsMessage.builder().build());
    }
}
