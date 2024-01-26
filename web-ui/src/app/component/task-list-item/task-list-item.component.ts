import {Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import {Task} from "../../service/task";

@Component({
  selector: 'app-task-list-item',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './task-list-item.component.html',
  styleUrl: './task-list-item.component.css'
})
export class TaskListItemComponent {
  @Input() task!: Task
}
