import {Component, EventEmitter, Input, Output} from '@angular/core';
import { CommonModule } from '@angular/common';
import {CreateGaol, Goal} from "../../service/goal";
import {CreateStep, Step} from "../../service/Step";
import {CreateStepComponent} from "../create-step/create-step.component";
import {StepListComponent} from "../step-list/step-list.component";
import {MatCardModule} from "@angular/material/card";
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {GoalService} from "../../service/goal.service";
import {GoalListComponent} from "../goal-list/goal-list.component";

@Component({
  selector: 'app-create-goal',
  standalone: true,
  imports: [CommonModule, CreateStepComponent, StepListComponent, MatCardModule, ReactiveFormsModule, GoalListComponent],
  templateUrl: './create-goal.component.html',
  styleUrl: './create-goal.component.css'
})
export class CreateGoalComponent {
  singleStepForm = new FormGroup(
    {
     description: new FormControl('', Validators.required),
     dueDate: new FormControl('', Validators.required)
    }
  )
  multiStepForm = new FormGroup([])
  @Output() createClicked = new EventEmitter<CreateGaol>();
  @Output() goalCreated = new EventEmitter<Goal>();


  constructor(private goalService: GoalService) {
  }



  onSingleSubmit() {
    let desc = this.singleStepForm.value.description!
    let dueDate = this.singleStepForm.value.dueDate!
    let newGoal : CreateGaol = {
      type: 'COMPLETE_BY',
      steps: [
        {
          description: desc,
          dueDate: dueDate
        }
      ]
    }
    this.goalService.sendCreateGoal(newGoal).subscribe(
      {
        next: value => {
          console.log('goal created:' + value);
          this.goalCreated.emit(value);
        },
        error: err => {
          console.error(err);
          this.goalCreated.emit(this.goalService.createGoal(newGoal))
        }
      }
    );
    this.singleStepForm.controls.description.setValue('')
    this.singleStepForm.controls.dueDate.setValue('')
  }
}

