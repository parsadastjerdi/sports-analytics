package com.sportsbook.sportsbook.service;

import com.sportsbook.sportsbook.dao.GameDao;
import com.sportsbook.sportsbook.model.Game;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameService {
    private final GameDao gameDao;

    public GameService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public int insertGame(Game game) {
        return gameDao.insertGame(game);
    }

    public List<Game> getAllGames() {
        return gameDao.selectAllGames();
    }

    public Optional<Game> getGameById(UUID gameId) {
        return gameDao.selectGameById(gameId);
    }

    public int deleteGame(UUID gameId) {
        return gameDao.deleteGameById(gameId);
    }

    public int updateGame(UUID gameId, Game game) {
        return gameDao.updateGameById(gameId, game);
    }

    public List<Game> getAllGamesWhoseDiffWasLessThanX(Integer pointDifference) {
        return gameDao.getAllGamesWhoseDiffWasLessThanX(pointDifference);
    }
}
