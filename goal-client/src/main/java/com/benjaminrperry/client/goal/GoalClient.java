package com.benjaminrperry.client.goal;



import com.benjaminrperry.goalquest.api.goal.Goal;
import com.benjaminrperry.goalquest.api.goal.dto.CreateGoalDTO;
import com.benjaminrperry.goalquest.api.goal.dto.GoalDTO;

import java.util.List;

public interface GoalClient {

    GoalDTO createGoal(CreateGoalDTO createGoalDTO);

    GoalDTO getGoal(Integer goalId);

    GoalDTO completeGoal(Integer goalId);

    List<GoalDTO> getAllGoals();
}
