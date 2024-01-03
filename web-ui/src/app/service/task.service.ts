import { Injectable } from '@angular/core';
import {Task, tasks} from './task';
import {Step} from "./Step";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  tasks: Task[] = [...tasks]

  constructor(private http: HttpClient) { }

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
  getDailyTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`http://localhost:8080/task`);
  }
}
