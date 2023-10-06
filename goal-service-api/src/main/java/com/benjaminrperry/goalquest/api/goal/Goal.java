package com.benjaminrperry.goalquest.api.goal;

import java.util.List;

public interface Goal {
    Long getId();
    String getDescription();
    boolean isCompleted();
    List<Step> getSteps();
    void setSteps(List<Step> steps);
    void addStep(Step step);
    void setCompleted(boolean completed);
}
