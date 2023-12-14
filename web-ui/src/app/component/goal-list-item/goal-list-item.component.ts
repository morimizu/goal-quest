import {Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import {Goal} from "../../service/goal";
import {MatListModule} from "@angular/material/list";

@Component({
  selector: 'app-goal-list-item',
  standalone: true,
  imports: [CommonModule, MatListModule],
  templateUrl: './goal-list-item.component.html',
  styleUrl: './goal-list-item.component.css'
})
export class GoalListItemComponent {
  @Input() goal!: Goal;
}
