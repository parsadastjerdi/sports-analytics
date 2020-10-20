insert into GamesInSeason(gameId, seasonId) (
    select game.gameId, season.seasonId
    from game, season
    where game.gameDate <= season.endDate
    AND game.gameDate >= season.startDate
);

-- TeamPlaysGame table
insert into TeamPlaysGame(homeTeamId, awayTeamId, gameId, homeTeamScore, awayTeamScore) (
    select homeTeam.teamId, awayTeam.teamId, game.gameId, random()::INTEGER, random()::INTEGER
    from team as homeTeam, team as awayTeam, game
    where homeTeam.teamId <> awayTeam.teamId
);

-- PlaysForTeam table
-- insert into PlaysForTeam(gameId, seasonId, startDate, endDate) (
    -- select player.playerId, team.teamId, random()::date, random()::date
    -- from player, team
   -- where
-- );

-- CoachesTeam table

