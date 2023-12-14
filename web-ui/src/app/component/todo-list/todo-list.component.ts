import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {TodoListItemComponent} from "../todo-list-item/todo-list-item.component";
import {tasks} from "../../service/task";
import {TaskService} from "../../service/task.service";

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [CommonModule, TodoListItemComponent],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.css'
})
export class TodoListComponent {
  tasks;

  constructor(private taskService: TaskService) {
    this.tasks = taskService.getDailyTasks()
  }

}
