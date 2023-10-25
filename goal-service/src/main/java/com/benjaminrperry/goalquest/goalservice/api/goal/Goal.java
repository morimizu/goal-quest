package com.benjaminrperry.goalquest.goalservice.api.goal;

import java.util.List;

public interface Goal {
    Long getId();
    String getDescription();
    boolean isCompleted();
    List<com.benjaminrperry.goalquest.goalservice.api.goal.Step> getSteps();
    void setSteps(List<com.benjaminrperry.goalquest.goalservice.api.goal.Step> steps);
    void addStep(Step step);
    void setCompleted(boolean completed);
}
