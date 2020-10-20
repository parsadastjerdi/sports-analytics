CREATE TABLE TeamPlaysGame (
    homeTeamId UUID REFERENCES team(teamId),
    awayTeamId UUID REFERENCES team(teamId),
    gameId UUID REFERENCES game(gameId),
    PRIMARY KEY (homeTeamId, awayTeamId, gameId),
    homeTeamScore Integer,
    awayTeamScore Integer
);