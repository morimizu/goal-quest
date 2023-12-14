export interface Step {
  id: number;
  description: string;
  completed: boolean
  dueDate: string
}

export interface CreateStep {
  description: string;
  dueDate: string;
}
