package com.benjaminrperry.goalquest.goalservice.api.goal;

import java.util.List;

public interface Goal {
    Long getId();
    GoalType getType();
    boolean isActive();
    List<Step> getSteps();
    void setSteps(List<Step> steps);
    void addStep(Step step);
    void setActive(boolean active);
}
