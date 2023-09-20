CREATE TABLE IF NOT EXISTS task (
  id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  description CHARACTER(500),
  goal_id NUMBER,
  order_index number,
  completed BOOLEAN
);