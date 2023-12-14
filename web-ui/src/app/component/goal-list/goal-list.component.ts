import {Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import {Goal} from "../../service/goal";
import {GoalListItemComponent} from "../goal-list-item/goal-list-item.component";
import {MatListModule} from "@angular/material/list";
import {MatCardModule} from "@angular/material/card";
import {GoalService} from "../../service/goal.service";

@Component({
  selector: 'app-goal-list',
  standalone: true,
  imports: [CommonModule, GoalListItemComponent, MatListModule, MatCardModule],
  templateUrl: './goal-list.component.html',
  styleUrl: './goal-list.component.css'
})
export class GoalListComponent {
  @Input() goals!: Goal[]

  constructor(private goalService: GoalService) {
    this.goals = goalService.getAllGoals()
  }

}
