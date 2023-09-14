package com.benjaminrperry.client.goal;

public interface Goal {
    public Integer getId();
    public String getDescription();
    public boolean isCompleted();

    public void setCompleted(boolean completed);
}
