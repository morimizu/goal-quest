package com.benjaminrperry.goalquest.api.goal;

public interface Goal {
    public Long getId();
    public String getDescription();
    public boolean isCompleted();
    

    public void setCompleted(boolean completed);
}
