insert into CoachesTeam(coachId, teamId, startDate, endDate) (
   select coach.coachId, team.teamId, '2020-12-12', '2020-12-12'
    from coach, team
    where coach.age < 50
);