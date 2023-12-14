import {Component, EventEmitter, Input, Output} from '@angular/core';
import { CommonModule } from '@angular/common';
import { CreateStep } from "../../service/Step";
import {FormControl, ReactiveFormsModule} from "@angular/forms";
import {MatButtonModule} from "@angular/material/button";
import {MatInputModule} from "@angular/material/input";

@Component({
  selector: 'app-create-step',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, MatButtonModule, MatInputModule],
  templateUrl: './create-step.component.html',
  styleUrl: './create-step.component.css'
})
export class CreateStepComponent {

  @Output() addStep = new EventEmitter<CreateStep>

  onClick() {
    this.addStep.emit(<CreateStep>{
      description: this.description.value,
      dueDate: ''
    })
  }
  description = new FormControl('')
}
