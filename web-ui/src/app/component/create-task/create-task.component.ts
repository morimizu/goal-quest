import {Component, EventEmitter, Output} from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {CreateTask, Task} from "../../service/task";
import {TaskService} from "../../service/task.service";

@Component({
  selector: 'app-create-task',
  standalone: true,
    imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './create-task.component.html',
  styleUrl: './create-task.component.css'
})
export class CreateTaskComponent {
  @Output() taskCreated = new EventEmitter<Task>();
  newTaskForm = new FormGroup(
    {
      description: new FormControl('', Validators.required),
      dueDate: new FormControl('', Validators.required)
    }
  )
  constructor(private task: TaskService) {
    this.task.taskCreated.subscribe(
      {next: () => { this.newTaskForm.reset() }}
    )
  }

  onSubmit() {
    let desc = this.newTaskForm.value.description!
    let dueDate = this.newTaskForm.value.dueDate!
    let newTask: CreateTask = {
      description: desc,
      dueDate: dueDate
    }
    console.log(newTask)
    this.task.createTask(newTask)
  }
}
