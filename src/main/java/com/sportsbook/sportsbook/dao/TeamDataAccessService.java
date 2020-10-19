package com.sportsbook.sportsbook.dao;

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
    public int insertTeam(UUID id, Team team) {
        return 0;
    }

    @Override
    public List<Team> selectAllTeams() {
        final String sql = "SELECT * FROM Team;";

        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID teamId = UUID.fromString(resultSet.getString("id"));
            return new Team(
                    teamId,
                    resultSet.getString("name"));
        });
    }

    @Override
    public Optional<Team> selectTeamById(UUID id) {
        final String sql = "SELECT * FROM Team WHERE id = ?";

        Team team = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
          UUID teamId = UUID.fromString(resultSet.getString("id"));
          String name = resultSet.getString("name");
          return new Team(teamId, name);
        });

        return Optional.ofNullable(team);
    };

    @Override
    public int deleteTeamById(UUID id) {
        /*
        Optional<Team> teamMaybe = selectTeamById(id);
        if (teamMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(teamMaybe.get());
        return 1;
         */
        return 0;
    }

    @Override
    public int updateTeamById(UUID id, Team updatedTeam) {
        /*
        return selectTeamById(id)
                .map(team -> {
                    int indexOfTeamToUpdate = DB.indexOf(team);
                    if (indexOfTeamToUpdate >= 0) {
                        DB.set(indexOfTeamToUpdate, new Team(id, updatedTeam.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
         */
        return 0;
    }
}
