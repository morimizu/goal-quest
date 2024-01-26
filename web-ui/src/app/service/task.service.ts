import {EventEmitter, Injectable, Output} from '@angular/core';
import {CreateTask, Task, tasks} from './task';
import {Step} from "./Step";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Goal} from "./goal";

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  tasks: Task[] = [...tasks]

  @Output() taskCreated = new EventEmitter<Task>()

  constructor(private http: HttpClient) { }

  completeTask(task: Task) :Task {
    task.completed = true;
    return task;
  }

  sendCreateTask(createTask: CreateTask): Observable<Task> {
    console.log(`sending post request with: ${JSON.stringify(createTask)}`)
    return  this.http.post<Task>(`http://localhost:8080/task`, createTask)
  }
  getDailyTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`http://localhost:8080/task`);
  }

  createTask(createTask: CreateTask) {
    this.sendCreateTask(createTask)
      .subscribe(
        {
          next: value => {
            console.log('task created:' + value);
            this.taskCreated.emit(value);
          },
          error: err => {
            console.error(err);
          }
        }
      );
  }
}
