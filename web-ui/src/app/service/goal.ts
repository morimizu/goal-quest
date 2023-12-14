import {CreateStep, Step} from "./Step";

export interface Goal {
  id: number;
  type: string;
  active: boolean;
  steps: Step[]
}

export interface CreateGaol {
  type: string;
  steps: CreateStep[]
}

export const goals: Goal[] = [

];
