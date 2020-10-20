package com.sportsbook.sportsbook.dao;

import com.sportsbook.sportsbook.model.Coach;
import com.sportsbook.sportsbook.model.Team;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CoachDao {
    int insertCoach(UUID coachId, Coach coach);

    default int insertCoach(Coach coach) {
        UUID id = UUID.randomUUID();
        return insertCoach(id, coach);
    }

    List<Coach> selectAllCoaches();

    Optional<Coach> selectCoachById(UUID coachId);

    int deleteCoachById(UUID coachId);

    int updateCoachById(UUID coachId, Coach coach);

    List<Team> getAllTeamsForACoach(UUID coachId);
}
