package com.benjaminrperry.goalquest.api.task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Task {
    Long getId();
    String getDescription();
    boolean isCompleted();
    LocalDate getDueDate();
    LocalDateTime getCompletionDate();
    void setDescription(String description);
    void complete();
    LocalDateTime getCreationDate();
}
