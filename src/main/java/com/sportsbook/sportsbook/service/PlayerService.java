package com.sportsbook.sportsbook.service;

import com.sportsbook.sportsbook.dao.PlayerDao;
import com.sportsbook.sportsbook.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    private final PlayerDao playerDao;

    @Autowired
    public PlayerService(@Qualifier("playerDao") PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public int addPlayer(Player player) {
        return playerDao.insertPlayer(player);
    }

    public List<Player> getAllPlayers() {
        return playerDao.selectAllPlayers();
    }

    public Optional<Player> getPlayerById(UUID playerId) {
        return playerDao.selectPlayerById(playerId);
    }

    public int deletePlayer(UUID playerId) {
        return playerDao.deletePlayerById(playerId);
    }

    public int updatePlayer(UUID playerId, Player newPlayer) {
        return playerDao.updatePlayerById(playerId, newPlayer);
    }

    public List<Player> getAllPlayersOnATeam(UUID teamId) {
        return playerDao.getAllPlayersOnATeam(teamId);
    }
}
