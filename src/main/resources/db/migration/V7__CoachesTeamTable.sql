CREATE TABLE CoachesTeam (
    coachId UUID REFERENCES coach(coachId),
    teamId UUID REFERENCES team(teamId),
    PRIMARY KEY (coachId, teamId),
    startDate date,
    endDate date
);