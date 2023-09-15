package com.benjaminrperry.client.goal;

import com.benjaminrperry.goalquest.api.goal.Goal;

import java.util.List;

public interface GoalClient {

    Goal createGoal(String description);

    Goal getGoal(Integer goalId);

    Goal completeGoal(Integer goalId);

    List<Goal> getAllGoals();
}
