import {Component, EventEmitter, Input, Output} from '@angular/core';
import { CommonModule } from '@angular/common';
import {Task, tasks} from "../../service/task";
import {TaskService} from "../../service/task.service";

@Component({
  selector: 'app-todo-list-item',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './todo-list-item.component.html',
  styleUrl: './todo-list-item.component.css'
})
export class TodoListItemComponent {
  @Input() task!: Task;

  @Output() onComplete: EventEmitter<Task> = new EventEmitter<Task>();

  constructor(private taskService: TaskService) {
  }

  getCheckedImage() : string {
    if (this.task == null || !this.task.completed) {
      return "/assets/check2-square-empty.png";
    }
    return "/assets/check2-square.svg"
  }

  fireComplete() {
    this.task = this.taskService.completeTask(this.task)
    this.onComplete.emit(this.task)
  }
}


