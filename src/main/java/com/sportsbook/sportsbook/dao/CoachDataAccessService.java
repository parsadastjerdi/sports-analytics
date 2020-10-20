package com.sportsbook.sportsbook.dao;

import com.sportsbook.sportsbook.model.Coach;
import com.sportsbook.sportsbook.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("coachDao")
public class CoachDataAccessService implements CoachDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CoachDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCoach(UUID coachId, Coach coach) {
        final String sql = "INSERT INTO coach " +
                "(coachId, name, age) " +
                "values (?, ?, ?);";
        return jdbcTemplate.update(sql,
                coachId,
                coach.getName(),
                coach.getAge());
    }

    @Override
    public List<Coach> selectAllCoaches() {
        final String sql = "SELECT * FROM coach;";
        return jdbcTemplate.query(sql,(resultSet, i) -> {
            UUID coachId = UUID.fromString(resultSet.getString("coachId"));
            return new Coach(
                    coachId,
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
        });
    }

    @Override
    public Optional<Coach> selectCoachById(UUID coachId) {
        final String sql = "SELECT * FROM coach WHERE coachId = ?;";
        Coach coach = jdbcTemplate.queryForObject(sql, new Object[]{coachId}, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("coachId"));
            return new Coach(id,
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
        });
        return Optional.ofNullable(coach);
    }

    @Override
    public int deleteCoachById(UUID coachId) {
        final String sql = "DELETE FROM coach WHERE coachId = ?;";
        return jdbcTemplate.update(sql, coachId);
    }

    @Override
    public int updateCoachById(UUID coachId, Coach coach) {
        final String sql = "UPDATE coach SET " +
                "name = ?, age = ? " +
                "WHERE coachId = ?;";
        return jdbcTemplate.update(sql,
                coach.getName(),
                coach.getAge(),
                coachId);
    }

    @Override
    public List<Team> getAllTeamsForACoach(UUID coachId) {
        final String sql = "select team.* " +
                "from team, coach, CoachesTeam " +
                "where CoachesTeam.coachId = coach.coachId AND " +
                "CoachesTeam.teamId = team.teamId AND " +
                "    coach.coachId = ?;";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID teamId = UUID.fromString(resultSet.getString("teamId"));
            return new Team(teamId,
                    resultSet.getString("name"),
                    resultSet.getString("city"),
                    resultSet.getString("conference"));
        }, coachId);
    }
}
