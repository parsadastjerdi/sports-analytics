package com.sportsbook.sportsbook.dao;

import com.sportsbook.sportsbook.model.Game;
import com.sportsbook.sportsbook.model.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("seasonDao")
public class SeasonDataAccessService implements SeasonDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SeasonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertSeason(UUID seasonId, Season season) {
        final String sql = "INSERT INTO season " +
                "(seasonId, startDate, endDate) " +
                " values (?, ?, ?);";
        return jdbcTemplate.update(sql,
                seasonId,
                season.getStartDate(),
                season.getEndDate());
    }

    @Override
    public List<Season> selectAllSeasons() {
        final String sql = "SELECT * FROM season;";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID seasonId = UUID.fromString(resultSet.getString("seasonId"));
            return new Season(
                    seasonId,
                    resultSet.getDate("startDate"),
                    resultSet.getDate("endDate"));
        });
    }

    @Override
    public Optional<Season> selectSeasonById(UUID seasonId) {
        final String sql = "SELECT * FROM season WHERE seasonId = ?;";
        Season season = jdbcTemplate.queryForObject(sql, new Object[]{seasonId}, (resultSet, i) -> {
           UUID id = UUID.fromString(resultSet.getString("seasonId"));
           return new Season(id,
                   resultSet.getDate("startDate"),
                   resultSet.getDate("endDate"));
        });
        return Optional.ofNullable(season);
    }

    @Override
    public int deleteSeasonById(UUID seasonId) {
        final String sql = "DELETE FROM season WHERE seasonId = ?;";
        return jdbcTemplate.update(sql, seasonId);
    }

    @Override
    public int updateSeasonById(UUID seasonId, Season season) {
        final String sql = "UPDATE season SET " +
                "startDate = ?, endDate = ? " +
                "WHERE seasonId = ?;";
        return jdbcTemplate.update(sql,
                season.getStartDate(),
                season.getEndDate(),
                seasonId);
    }

    @Override
    public List<Game> getAllGamesInASeason(UUID seasonId) {
        final String sql = "select game.* " +
                "from game, GamesInSeason, season " +
                "where GamesInSeason.seasonId = ? AND " +
                "    GamesInSeason.gameId = game.gameId;";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID gameId = UUID.fromString(resultSet.getString("gameId"));
            return new Game(
                   gameId,
                   resultSet.getString("venue"),
                   resultSet.getDate("gameDate"));
        }, seasonId);
    }
}
