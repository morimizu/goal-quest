import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {NgbCollapseModule} from "@ng-bootstrap/ng-bootstrap";
import {GoalListComponent} from "../goal-list/goal-list.component";

@Component({
  selector: 'app-side-drawer',
  standalone: true,
  imports: [CommonModule, NgbCollapseModule, GoalListComponent],
  templateUrl: './side-drawer.component.html',
  styleUrl: './side-drawer.component.css'
})
export class SideDrawerComponent {
  isCollapsed = false;
  toggle() {
    this.isCollapsed = !this.isCollapsed
  }
}
