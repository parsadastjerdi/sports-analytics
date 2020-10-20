package com.sportsbook.sportsbook.dao;

import com.sportsbook.sportsbook.model.Coach;
import com.sportsbook.sportsbook.model.Team;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeamDao {
    int insertTeam(UUID teamId, Team team);

    default int insertTeam(Team team) {
        UUID id = UUID.randomUUID();
        return insertTeam(id, team);
    }

    List<Team> selectAllTeams();

    Optional<Team> selectTeamById(UUID teamId);

    int deleteTeamById(UUID teamId);

    int updateTeamById(UUID teamId, Team team);

    List<Coach> getAllCoachesInAConference(String conference);
}
