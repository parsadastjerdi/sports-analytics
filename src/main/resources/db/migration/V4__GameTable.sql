CREATE TABLE Game (
    gameId UUID NOT NULL PRIMARY KEY,
    seasonId UUID REFERENCES season(seasonId),
    venue VARCHAR(50),
    gameDate date
)