CREATE TABLE GamesInSeason (
    gameId UUID REFERENCES game(gameId),
    seasonId UUID REFERENCES season(seasonId),
    PRIMARY KEY (gameId, seasonId)
);