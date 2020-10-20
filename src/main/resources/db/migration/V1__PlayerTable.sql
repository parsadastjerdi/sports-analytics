CREATE TABLE Player (
    playerId UUID NOT NULL PRIMARY KEY,
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    position VARCHAR(2),
    height INTEGER,
    weight INTEGER,
    age INTEGER
);