package com.benjaminrperry.goalservice.api;

public interface Goal {
    public Integer getId();
    public String getDescription();
    public boolean isCompleted();

    public void setCompleted(boolean completed);
}
