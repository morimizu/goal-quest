package com.benjaminrperry.goalquest.goalservice.api.goal;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public interface Step {
    Long getId();
    Goal getGoal();
    String getDescription();

    LocalDateTime getDueDate();
    boolean isCompleted();

    LocalDateTime getCompletionDate();

}
