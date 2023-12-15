import {Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import {Goal, goals} from "../../service/goal";
import {GoalListItemComponent} from "../goal-list-item/goal-list-item.component";
import {MatListModule} from "@angular/material/list";
import {MatCardModule} from "@angular/material/card";
import {GoalService} from "../../service/goal.service";
import {log} from "@angular-devkit/build-angular/src/builders/ssr-dev-server";

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
    // this.goals = goals;
    this.refreshGoals()
  }

    refreshGoals() {
      this.goalService.getAllGoals().subscribe({
        next: (v) => this.goals = v,
        error: (e) => this.goals = goals,
        complete: () => console.info('complete')
      })

}


}
