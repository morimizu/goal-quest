import {Component, ElementRef, ViewChild} from '@angular/core';
import { CommonModule } from '@angular/common';
import {CreateGoalComponent} from "../create-goal/create-goal.component";
import {GoalListComponent} from "../goal-list/goal-list.component";
import {CreateTaskComponent} from "../create-task/create-task.component";

@Component({
  selector: 'app-manage-goals',
  standalone: true,
  imports: [CommonModule, CreateGoalComponent, GoalListComponent, CreateTaskComponent],
  templateUrl: './manage-tasks.component.html',
  styleUrl: './manage-tasks.component.css'
})
export class ManageTasksComponent {
  @ViewChild(GoalListComponent) goalList!: GoalListComponent;
}
