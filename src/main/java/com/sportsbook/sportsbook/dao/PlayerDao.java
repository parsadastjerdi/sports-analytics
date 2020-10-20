package com.sportsbook.sportsbook.dao;

import com.sportsbook.sportsbook.model.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerDao {
    int insertPlayer(UUID playerId, Player player);

    default int insertPlayer(Player player) {
        UUID id = UUID.randomUUID();
        return insertPlayer(id, player);
    }

    List<Player> selectAllPlayers();

    Optional<Player> selectPlayerById(UUID playerId);

    int deletePlayerById(UUID playerId);

    int updatePlayerById(UUID playerId, Player player);

    List<Player> getAllPlayersOnATeam(UUID teamId);
}
