import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {GoalListItemComponent} from "../goal-list-item/goal-list-item.component";
import { Task } from '../../service/task';
import {TaskService} from "../../service/task.service";
import {TaskListItemComponent} from "../task-list-item/task-list-item.component";

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule, GoalListItemComponent, TaskListItemComponent],
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css'
})
export class TaskListComponent {
   tasks: Task[] = []

  constructor(private taskService: TaskService) {
     this.loadTasks()
  }

  loadTasks() {
     this.taskService.getAllTasks().subscribe(
       {
         next: value => {
           this.tasks = value;
         },
         error: err => {
           console.error(err)
         }
       }
     )
  }

}
