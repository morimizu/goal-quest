import {Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import {GoalListItemComponent} from "../goal-list-item/goal-list-item.component";
import {CreateStep, Step} from "../../service/Step";
import {StepListItemComponent} from "../step-list-item/step-list-item.component";
import {MatListModule} from "@angular/material/list";

@Component({
  selector: 'app-step-list',
  standalone: true,
  imports: [CommonModule, GoalListItemComponent, StepListItemComponent, MatListModule],
  templateUrl: './step-list.component.html',
  styleUrl: './step-list.component.css'
})
export class StepListComponent {
  @Input() steps!: CreateStep[]
}
