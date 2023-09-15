package com.benjaminrperry.goalservice.messaging;

import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.goal.messaging.CompleteGoalMessage;
import com.benjaminrperry.goalquest.api.goal.messaging.CreateGoalMessage;
import com.benjaminrperry.goalquest.api.goal.messaging.GetGoalMessage;
import com.benjaminrperry.goalquest.api.goal.messaging.GetGoalsMessage;
import com.benjaminrperry.goalservice.service.GoalService;
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
    public Goal handelCreateGoal(@Payload CreateGoalMessage createGoalMessage) {
        log.info("received new message: "+ createGoalMessage);
        return goalService.createGoal(createGoalMessage.getDescription());
    }

    @RabbitHandler
    public Optional<Goal> handelGetGoal(@Payload GetGoalMessage getGoalMessage) {
        return goalService.findGoalById(getGoalMessage.getGoalId());
    }

    @RabbitHandler
    public List<Goal> handelGetGoals(@Payload GetGoalsMessage getGoalsMessage) {
        if(getGoalsMessage.getGoalId() != null) {
            return List.of(goalService.findGoalById(getGoalsMessage.getGoalId()).orElseThrow(()-> new NoSuchElementException("cannot find goal")));
        }
        return goalService.findAllGoals();
    }

    @RabbitHandler
    public Goal handelCompleteGoal(@Payload CompleteGoalMessage completeGoalMessage) {
        return goalService.completeGoal(completeGoalMessage.getGoalId());
    }
}
