import { Routes } from '@angular/router';
import {CreateGoalComponent} from "./component/create-goal/create-goal.component";
import {ManageGoalsComponent} from "./component/manage-goals/manage-goals.component";

export const routes: Routes = [
  {
    path: '',
    component: ManageGoalsComponent
  }
];
