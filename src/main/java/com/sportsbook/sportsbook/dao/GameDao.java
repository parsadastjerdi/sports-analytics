package com.sportsbook.sportsbook.dao;

import com.sportsbook.sportsbook.model.Game;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GameDao {
    int insertGame(UUID gameId, Game game);

    default int insertGame(Game game) {
        UUID id = UUID.randomUUID();
        return insertGame(id, game);
    }

    List<Game> selectAllGames();

    Optional<Game> selectGameById(UUID gameId);

    int deleteGameById(UUID gameId);

    int updateGameById(UUID gameId, Game game);

    List<Game> getAllGamesWhoseDiffWasLessThanX(Integer pointDifference);
}
