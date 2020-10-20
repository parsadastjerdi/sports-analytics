package com.sportsbook.sportsbook.dao;

import com.sportsbook.sportsbook.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("gameDao")
public class GameDataAccessService implements GameDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertGame(UUID gameId, Game game) {
        final String sql = "INSERT INTO game " +
                "(gameId, venue, gameDate) " +
                "values (?, ?, ?);";
        return jdbcTemplate.update(sql,
                gameId,
                game.getVenue(),
                game.getGameDate());
    }

    @Override
    public List<Game> selectAllGames() {
        final String sql = "SELECT * FROM game;";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID gameId = UUID.fromString(resultSet.getString("gameId"));
            return new Game(
                    gameId,
                    resultSet.getString("venue"),
                    resultSet.getDate("gameDate"));
        });
    }

    @Override
    public Optional<Game> selectGameById(UUID gameId) {
        final String sql = "SELECT * FROM game WHERE gameId = ?;";
        Game game = jdbcTemplate.queryForObject(sql, new Object[]{gameId}, (resultSet, i) -> {
            UUID gid = UUID.fromString(resultSet.getString("gameId"));
            return new Game(gid,
                    resultSet.getString("venue"),
                    resultSet.getDate("gameDate"));
        });
        return Optional.ofNullable(game);
    }

    @Override
    public int deleteGameById(UUID gameId) {
        final String sql = "DELETE FROM game WHERE gameId = ?;";
        return jdbcTemplate.update(sql, gameId);
    }

    @Override
    public int updateGameById(UUID gameId, Game game) {
        final String sql = "UPDATE game SET " +
                "venue = ?, gameDate = ? " +
                "WHERE gameId = ?;";
        return jdbcTemplate.update(sql,
                game.getVenue(),
                game.getGameDate(),
                gameId);
    }

    @Override
    public List<Game> getAllGamesWhoseDiffWasLessThanX(Integer pointDifference) {
        final String sql = "select game.* " +
                "from game, TeamPlaysGame " +
                "where (TeamPlaysGame.homeTeamScore - TeamPlaysGame.awayTeamScore < ?) " +
                "    AND (TeamPlaysGame.homeTeamScore - TeamPlaysGame.awayTeamScore >= 0) " +
                "    AND TeamPlaysGame.gameId = game.gameId;";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID gameId = UUID.fromString(resultSet.getString("gameId"));
            return new Game(
                    gameId,
                    resultSet.getString("venue"),
                    resultSet.getDate("gameDate"));
        }, pointDifference);
    }
}
