insert into PlaysForTeam(playerId, teamId, startDate, endDate) (
   select player.playerId, team.teamId,
    '1/1/1900'::date + ('1 year'::interval*floor(random()*120)),
    '1/1/1900'::date + ('1 year'::interval*floor(random()*120))
    from player, team
    where player.age > random() * 30 AND player.age < random() * 40
);
