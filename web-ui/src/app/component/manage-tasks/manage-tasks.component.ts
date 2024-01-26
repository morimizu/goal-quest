import {Component, ElementRef, ViewChild} from '@angular/core';
import { CommonModule } from '@angular/common';
import {CreateGoalComponent} from "../create-goal/create-goal.component";
import {GoalListComponent} from "../goal-list/goal-list.component";
import {CreateTaskComponent} from "../create-task/create-task.component";
import {TaskListComponent} from "../task-list/task-list.component";
import {TaskService} from "../../service/task.service";

@Component({
  selector: 'app-manage-tasks',
  standalone: true,
  imports: [CommonModule, CreateTaskComponent, TaskListComponent],
  templateUrl: './manage-tasks.component.html',
  styleUrl: './manage-tasks.component.css'
})
export class ManageTasksComponent {
  @ViewChild(TaskListComponent) taskList!: TaskListComponent;

  constructor(private taskService: TaskService) {
    this.taskService.taskCreated.subscribe(
      {
     next: () => {this.reloadList()}}
    )
  }

  reloadList() {
    this.taskList.loadTasks()
  }
}
