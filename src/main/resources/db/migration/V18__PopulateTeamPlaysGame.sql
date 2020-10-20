insert into TeamPlaysGame(teamId, gameId, homeTeamScore, awayTeamScore)
select team.teamId, game.gameId, round(random() * 100), round(random() * 100)
from team, game




