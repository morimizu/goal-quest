import { Injectable } from '@angular/core';
import {Task, tasks} from './task';
import {Step} from "./Step";

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  tasks: Task[] = [...tasks]

  constructor() { }

  completeTask(task: Task) :Task {
    task.completed = true;
    return task;
  }

  createTask(step: Step) {
    let newTask: Task = {
      id: step.id,
      type: 'COMPLETE_BY',
      completed: false,
      description: step.description
    }
    this.tasks.push(newTask)
  }
  getDailyTasks(): Task[] {
    return this.tasks
  }
}
