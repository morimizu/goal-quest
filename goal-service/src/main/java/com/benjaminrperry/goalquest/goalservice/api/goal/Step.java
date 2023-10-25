package com.benjaminrperry.goalquest.goalservice.api.goal;

public interface Step {
    Long getId();
    Goal getGoal();
    String getDescription();
    Integer getOrderIndex();

    boolean isCompleted();
}
