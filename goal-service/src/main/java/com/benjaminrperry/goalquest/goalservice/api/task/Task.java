package com.benjaminrperry.goalquest.goalservice.api.task;

public interface Task {
    Long getId();
    Long getGoalId();
    String getDescription();
    Integer getOrderIndex();
    boolean isComplete();
    void setDescription(String description);
    void setOrderIndex(Integer orderIndex);
    void setComplete(boolean complete);
}
