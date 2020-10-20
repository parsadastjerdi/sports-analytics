insert into CoachesTeam(coachId, teamId, startDate, endDate) (
   select coach.coachId, team.teamId,
   '1/1/1900'::date + ('1 year'::interval*floor(random()*120)),
   '1/1/1900'::date + ('1 year'::interval*floor(random()*120))
    from coach, team
    where  coach.age > random() * 30 AND coach.age < random() * 50
);