CREATE TABLE f_food(
  id SERIAL PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  description VARCHAR(64) NOT NULL,
  calories VARCHAR(64) NOT NULL,
  fat VARCHAR(64) NOT NULL,
  protien VARCHAR(64) NOT NULL,
  carbs VARCHAR(64) NOT NULL,
  servings VARCHAR(64) NOT NULL
);