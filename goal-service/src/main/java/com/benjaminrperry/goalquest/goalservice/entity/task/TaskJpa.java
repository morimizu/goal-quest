package com.benjaminrperry.goalquest.goalservice.entity.task;

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
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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
    @Column(name = "step_id")
    private Long stepId;
    @Column(name = "description")
    private String description;
    @Column(name = "completed")
    private boolean completed;
    @Column(name = "completion_date")
    private LocalDateTime completionDate;
    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;


    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void complete() {
        this.completed = true;
        this.completionDate = LocalDateTime.now();
    }
}
