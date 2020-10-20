CREATE TABLE PlaysForTeam (
    playerId UUID REFERENCES player(playerId),
    teamId UUID REFERENCES team(teamId),
    PRIMARY KEY(playerId, teamId),
    startDate date,
    endDate date
);