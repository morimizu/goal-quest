package com.benjaminrperry.goalquest.goalservice.messaging;

import com.benjaminrperry.goalquest.goalservice.api.goal.dto.GoalDTO;
import com.benjaminrperry.goalquest.goalservice.api.goal.messaging.CreateGoalMessage;
import com.benjaminrperry.goalquest.goalservice.api.goal.messaging.GetGoalMessage;
import com.benjaminrperry.goalquest.goalservice.api.goal.messaging.GetGoalsMessage;
import com.benjaminrperry.goalquest.goalservice.converter.GoalConverter;
import com.benjaminrperry.goalquest.goalservice.service.GoalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RabbitListener(queues = "${goalquest.rabbit.bindings.goal.queue-name}")
@Component
@Slf4j
@RequiredArgsConstructor
public class GoalMessageProcessor {

    private final GoalService goalService;

    @RabbitHandler
    public GoalDTO handelCreateGoal(@Payload CreateGoalMessage createGoalMessage) {
        log.info("received new message: "+ createGoalMessage);
        var goal = goalService.createGoal(createGoalMessage.getType(), createGoalMessage.getStepList());
        return GoalConverter.toGoalDTO(goal);
    }

    @RabbitHandler
    public Optional<GoalDTO> handelGetGoal(@Payload GetGoalMessage getGoalMessage) {
        return goalService.findGoalById(getGoalMessage.getGoalId())
                .map(GoalConverter::toGoalDTO);
    }

    @RabbitHandler
    public List<GoalDTO> handelGetGoals(@Payload GetGoalsMessage getGoalsMessage) {
        return goalService.findAllGoals().stream()
                .map(GoalConverter::toGoalDTO)
                .toList();
    }
}
