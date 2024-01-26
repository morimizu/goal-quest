

export interface Task {
  id: number;
  type: string;
  completed: boolean;
  description: string;
  dueDate: string;
  completionDate: string;
  creationDate: string;
}

export interface CreateTask {
  description: string;
  dueDate: string;
}

export const tasks = [
];
