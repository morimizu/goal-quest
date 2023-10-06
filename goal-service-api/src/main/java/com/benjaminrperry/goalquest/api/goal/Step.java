package com.benjaminrperry.goalquest.api.goal;

public interface Step {
    Long getId();
    Goal getGoal();
    String getDescription();
    Integer getOrderIndex();

    boolean isCompleted();
}
