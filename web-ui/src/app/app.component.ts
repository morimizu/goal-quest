import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import {CreateGoalComponent} from "./component/create-goal/create-goal.component";
import {GoalService} from "./service/goal.service";
import {CreateGaol, Goal} from "./service/goal";
import {GoalListComponent} from "./component/goal-list/goal-list.component";
import {MatSidenavModule} from "@angular/material/sidenav";
import {NavbarComponent} from "./component/navbar/navbar.component";
import {SideDrawerComponent} from "./component/side-drawer/side-drawer.component";
import {TodoListComponent} from "./component/todo-list/todo-list.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, CreateGoalComponent, GoalListComponent, MatSidenavModule, NavbarComponent, SideDrawerComponent, TodoListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Goal Quest';
  goals: Goal[];

  constructor(goalService: GoalService) {
    this.goals = goalService.getAllGoals();
  }

  createGoal(createGoal: CreateGaol){

  }
}
