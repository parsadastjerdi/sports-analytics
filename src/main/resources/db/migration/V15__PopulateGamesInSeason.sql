insert into GamesInSeason(gameId, seasonId) (
    select game.gameId, season.seasonId
    from game, season
    where game.gameDate <= season.endDate
    AND game.gameDate >= season.startDate
);
