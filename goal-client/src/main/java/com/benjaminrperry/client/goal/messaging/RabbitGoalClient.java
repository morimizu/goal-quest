package com.benjaminrperry.client.goal.messaging;


import com.benjaminrperry.client.goal.GoalClient;
import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.goal.messaging.CompleteGoalMessage;
import com.benjaminrperry.goalquest.api.goal.messaging.CreateGoalMessage;
import com.benjaminrperry.goalquest.api.goal.messaging.GetGoalMessage;
import com.benjaminrperry.goalquest.api.goal.messaging.GetGoalsMessage;
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
