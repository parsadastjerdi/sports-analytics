CREATE TABLE Team (
    teamId UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(100),
    conference VARCHAR(4)
);