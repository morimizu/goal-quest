package com.benjaminrperry.goalquest.taskservice.entity.task;

import com.benjaminrperry.goalquest.api.task.Task;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskJpa implements Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "goal_id")
    private Long goalId;
    @Column(name = "order_index")
    private Integer orderIndex;
    @Column(name = "description")
    private String description;
    @Column(name = "complete")
    private boolean complete;

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    @Override
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

}
