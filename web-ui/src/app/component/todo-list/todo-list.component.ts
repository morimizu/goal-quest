import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {TodoListItemComponent} from "../todo-list-item/todo-list-item.component";
import {Task, tasks} from "../../service/task";
import {TaskService} from "../../service/task.service";

@Component({
  selector: 'app-todo-list',
  standalone: true,
  imports: [CommonModule, TodoListItemComponent],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.css'
})
export class TodoListComponent {
  tasks: Task[] = tasks

  constructor(private taskService: TaskService) {
    this.reloadList()
    taskService.taskCreated.subscribe({
      next: () => {
        console.log(`ToDoList heard task created next`)
        this.reloadList()
      }
    })
  }

  reloadList() {
    this.taskService.getDailyTasks()
      .subscribe({
        next: value => this.tasks = value,
        error: err => console.error(err),
        complete: () => console.info('todolist loaded')
      })
  }

}
