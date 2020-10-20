-- this doesn't actually perform any migrations because the name has one less underscore than it is supposed to
-- just using it to draft sql statements

drop database sportsbookdb;
create database sportsbookdb;

insert into TeamPlaysGame(homeTeamId, awayTeamId, gameId, homeTeamScore, awayTeamScore) (
   select homeTeam.teamId as homeTeamId, awayTeam.teamId as awayTeamId, game.gameId,
   random() * 100, random() * 100
   from team as homeTeam, team as awayTeam
   inner join game gameId on homeTeam.teamId <> awayTeam.teamId
    -- from team as homeTeam, team as awayTeam, game
    -- where homeTeam.teamId <> awayTeam.teamId
);

select gameId from game
union all
select homeTeam.teamId as homeTeamId, awayTeam.teamId as awayTeamId
from team as homeTeam, team as awayTeam
where homeTeam.teamId <> awayTeam.teamId
order by random()
limit 3000;

select team.teamId, team.teamId, game.gameId
from game
natural join (
    select homeTeam.teamId as homeTeamId, awayTeam.teamId as awayTeamId
    from team as homeTeam, team as awayTeam
    where homeTeam.teamId <> awayTeam.teamId
    order by random()
    limit 3000
) as teams;

-- get average age of all players on X team
select avg(player.age)
from player, PlaysForTeam
where player.playerId = PlaysForTeam.playerId AND
    PlaysForTeam.teamId = 'cd2a8e53-019d-4fbf-9c49-c57af3d11581';

----------------------------------------------------------
-- player: get all players who played on X team
select player.*
from player, PlaysForTeam
where player.playerId = PlaysForTeam.playerId AND
    PlaysForTeam.teamId = teamId;

-- coach: get all coaches in X conference
select coach.*
from coach, CoachesTeam, Team
where coach.coachId = CoachesTeam.coachId AND CoachesTeam.teamId = Team.teamId AND Team.conference = 'east';

-- game: get all games whose difference was less than X
select game.*, TeamPlaysGame.homeTeamScore - TeamPlaysGame.awayTeamScore
from game, TeamPlaysGame
where (TeamPlaysGame.homeTeamScore - TeamPlaysGame.awayTeamScore < 5)
    AND TeamPlaysGame.homeTeamScore - TeamPlaysGame.awayTeamScore > 0
    AND TeamPlaysGame.gameId = game.gameId;

-- season?: get all games in season X
select game.*
from game, GamesInSeason, season
where GamesInSeason.seasonId = 'a3ba58d7-137a-47ae-8540-8a2e4dd717bb' AND
    GamesInSeason.gameId = game.gameId;

-- team: get all teams who have played for a given coach
select team.*
from team, coach, CoachesTeam
where CoachesTeam.coachId = coach.coachId AND CoachesTeam.teamId = team.teamId AND
    coach.coachId = '5ae1ced5-8ef8-4f66-b7cc-7fadf08d52df';



