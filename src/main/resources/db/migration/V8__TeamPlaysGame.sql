CREATE TABLE TeamPlaysGame (
    teamId UUID REFERENCES team(teamId),
    gameId UUID REFERENCES game(gameId),
    PRIMARY KEY (teamId, gameId),
    homeTeamScore Integer,
    awayTeamScore Integer
);