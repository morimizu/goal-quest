package com.benjaminrperry.client.goal.messaging;


import com.benjaminrperry.client.goal.GoalClient;
import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.goal.dto.CreateGoalDTO;
import com.benjaminrperry.goalquest.api.goal.dto.GoalDTO;
import com.benjaminrperry.goalquest.api.goal.messaging.CompleteGoalMessage;
import com.benjaminrperry.goalquest.api.goal.messaging.CreateGoalMessage;
import com.benjaminrperry.goalquest.api.goal.messaging.GetGoalMessage;
import com.benjaminrperry.goalquest.api.goal.messaging.GetGoalsMessage;
import com.benjaminrperry.messaging.RabbitSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitGoalClient implements GoalClient {

    private final RabbitSender sender;

    @Value("${goalquest.rabbit.exchange-name}")
    private String exchangeName;

    @Value("${goalquest.rabbit.bindings.goal.routing-key}")
    private String routingKey;

    @Override
    public GoalDTO createGoal(CreateGoalDTO createGoalDTO){
        log.info("received CreateGoalDTO request");
        var createGoal = CreateGoalMessage.builder()
                .type(createGoalDTO.getType())
                .stepList(createGoalDTO.getSteps())
                .build();
        log.info("sending CreateGoalMessage");
        return (GoalDTO) sender.sendAndReceive(exchangeName, routingKey, createGoal);
    }

    @Override
    public GoalDTO getGoal(Integer goalId) {
        var getGoal = GetGoalMessage.builder().goalId(goalId).build();
        return (GoalDTO) sender.sendAndReceive(exchangeName, routingKey, getGoal);
    }

    @Override
    public GoalDTO completeGoal(Integer goalId) {
        var completeGoal = CompleteGoalMessage.builder().goalId(goalId).build();
        return (GoalDTO) sender.sendAndReceive(exchangeName, routingKey, completeGoal);
    }

    @Override
    public List<GoalDTO> getAllGoals() {
        return (List<GoalDTO>) sender.sendAndReceive(exchangeName, routingKey, GetGoalsMessage.builder().build());
    }
}
