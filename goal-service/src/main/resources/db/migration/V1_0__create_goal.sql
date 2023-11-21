CREATE TABLE IF NOT EXISTS goals (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  type nvarchar(50) NOT NULL,
  active BOOLEAN,
  creation_date TIMESTAMP
);
CREATE TABLE IF NOT EXISTS steps (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    goal_id int NOT NULL,
    description TEXT NOT NULL ,
    due_date TIMESTAMP NULL,
    completed BOOLEAN NOT NULL,
    completion_date TIMESTAMP NULL,
    creation_date TIMESTAMP NOT NULL
);
CREATE TABLE IF NOT EXISTS tasks (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    step_id int NOT NULL,
    description TEXT NOT NULL ,
    due_date TIMESTAMP NULL,
    completed BOOLEAN NOT NULL,
    completion_date TIMESTAMP NULL,
    creation_date TIMESTAMP NOT NULL
);