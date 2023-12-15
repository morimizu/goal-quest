package com.benjaminrperry.goalquest.api.goal;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Step {
    Long getId();
    Goal getGoal();

    void setGoal(Goal goal);
    String getDescription();

    LocalDate getDueDate();
    boolean isCompleted();

    LocalDateTime getCompletionDate();

}
