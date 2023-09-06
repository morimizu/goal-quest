package com.benjaminrperry.goalservice.api;

import java.util.List;

public interface GoalClient {

    public Goal createGoal(String description);

    public Goal getGoal(Integer goalId);

    public Goal completeGoal(Integer goalId);

    public List<Goal> getAllGoals();
}
