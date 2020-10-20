insert into PlaysForTeam(playerId, teamId, startDate, endDate) (
   select player.playerId, team.teamId, '2020-12-12', '2020-12-12'
    from player, team
    where player.age > 25
);
