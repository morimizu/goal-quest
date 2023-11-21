package com.benjaminrperry.goalquest.goalservice.api.task;

import java.time.LocalDateTime;

public interface Task {
    Long getId();
    Long getStepId();
    String getDescription();
    boolean isCompleted();
    LocalDateTime getCompletionDate();
    void setDescription(String description);
    void complete();
}
