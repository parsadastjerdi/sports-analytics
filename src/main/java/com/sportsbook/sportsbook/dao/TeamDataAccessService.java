package com.sportsbook.sportsbook.dao;

import com.sportsbook.sportsbook.model.Coach;
import com.sportsbook.sportsbook.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("teamDao")
public class TeamDataAccessService implements TeamDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TeamDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTeam(UUID teamId, Team team) {
        final String sql = "INSERT INTO team " +
                "(teamId, name, city, conference) " +
                " values (?, ?, ?, ?);";

        return jdbcTemplate.update(sql,
                teamId,
                team.getName(),
                team.getCity(),
                team.getConference());
    }

    @Override
    public List<Team> selectAllTeams() {
        final String sql = "SELECT * FROM Team;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID teamId = UUID.fromString(resultSet.getString("teamId"));
            return new Team(
                    teamId,
                    resultSet.getString("name"),
                    resultSet.getString("city"),
                    resultSet.getString("conference"));
        });
    }

    @Override
    public Optional<Team> selectTeamById(UUID teamId) {
        final String sql = "SELECT * FROM Team WHERE teamId = ?;";

        Team team = jdbcTemplate.queryForObject(sql, new Object[]{teamId}, (resultSet, i) -> {
          UUID id = UUID.fromString(resultSet.getString("teamId"));
          String name = resultSet.getString("name");
          String city = resultSet.getString("city");
          String conference = resultSet.getString("conference");
          return new Team(id, name, city, conference);
        });

        return Optional.ofNullable(team);
    };

    @Override
    public int deleteTeamById(UUID teamId) {
        final String sql = "DELETE FROM team WHERE teamId = ?;";
        return jdbcTemplate.update(sql, teamId);
    }

    @Override
    public int updateTeamById(UUID teamId, Team updatedTeam) {
        final String sql = "UPDATE team SET "
                + "name = ?, city = ?, conference = ?"
                + "WHERE teamId = ?;";

        return jdbcTemplate.update(sql,
                updatedTeam.getName(),
                updatedTeam.getCity(),
                updatedTeam.getConference(),
                teamId);
    }

    @Override
    public List<Coach> getAllCoachesInAConference(String conference) {
        final String sql = "select coach.* " +
                "from coach, CoachesTeam, Team " +
                "where coach.coachId = CoachesTeam.coachId AND " +
                "CoachesTeam.teamId = Team.teamId AND " +
                "Team.conference = ?;";
        return jdbcTemplate.query(sql, new Object[]{conference}, (resultSet, i) -> {
            UUID coachId = UUID.fromString(resultSet.getString("coachId"));
            return new Coach(
                    coachId,
                    resultSet.getString("name"),
                    resultSet.getInt("age"));
        });
    }
}
