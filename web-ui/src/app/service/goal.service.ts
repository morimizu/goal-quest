import {Injectable} from '@angular/core';
import {CreateGaol, Goal, goals} from "./goal";
import {Step} from "./Step";
import {TaskService} from "./task.service";

@Injectable({
  providedIn: 'root'
})
export class GoalService {
  private goals = [...goals]

  constructor(private taskService: TaskService) { }

  getAllGoals() : Goal[] {
    return this.goals;
  }

  getGoalById(id: number) : Goal {
    return <Goal>this.goals.find(goal => goal.id == id);
  }

  createGoal(createGoal: CreateGaol) : Goal {
    let newGoal: Goal = {
      id: this.goals.length,
      type: createGoal.type,
      active: true,
      steps: createGoal.steps.map(step=> {
        let newStep = {
          id: this.goals.length + createGoal.steps.indexOf(step),
          description: step.description,
          completed: false,
          dueDate: step.dueDate
        }
        this.taskService.createTask(newStep);
        return newStep;
      })
    }
    this.goals.push(newGoal)
    return newGoal;
  }
}