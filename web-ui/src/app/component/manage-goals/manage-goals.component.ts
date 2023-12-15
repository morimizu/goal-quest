import {Component, ElementRef, ViewChild} from '@angular/core';
import { CommonModule } from '@angular/common';
import {CreateGoalComponent} from "../create-goal/create-goal.component";
import {GoalListComponent} from "../goal-list/goal-list.component";

@Component({
  selector: 'app-manage-goals',
  standalone: true,
  imports: [CommonModule, CreateGoalComponent, GoalListComponent],
  templateUrl: './manage-goals.component.html',
  styleUrl: './manage-goals.component.css'
})
export class ManageGoalsComponent {
  @ViewChild(GoalListComponent) goalList!: GoalListComponent;
}
