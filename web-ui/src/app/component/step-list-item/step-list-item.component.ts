import {Component, Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import {CreateStep, Step} from "../../service/Step";
import {MatListModule} from "@angular/material/list";

@Component({
  selector: 'app-step-list-item',
  standalone: true,
  imports: [CommonModule, MatListModule],
  templateUrl: './step-list-item.component.html',
  styleUrl: './step-list-item.component.css'
})
export class StepListItemComponent {
  @Input() step!: CreateStep;
}
