CREATE TABLE c_user(
   id SERIAL PRIMARY KEY,
   first_name VARCHAR(64) NOT NULL,
   last_name VARCHAR(64) NOT NULL,
   email VARCHAR(128) NOT NULL,
   weight VARCHAR(64) NOT NULL,
   height VARCHAR(64) NOT NULL
);