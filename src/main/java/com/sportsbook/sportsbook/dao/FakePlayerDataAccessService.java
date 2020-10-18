package com.sportsbook.sportsbook.dao;


import com.sportsbook.sportsbook.model.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePlayerDataAccessService implements PlayerDao {
    // Temporary placeholder for players in the DB
    private static List<Player> DB = new ArrayList<>();

    @Override
    public int insertPlayer(UUID playerId, Player player) {
        DB.add(new Player(playerId, player.getTeamId(), player.getFirstName(), player.getLastName(),
                player.getPosition(), player.getHeight(), player.getWeight(), player.getAge()));
        return 0;
    }

    @Override
    public List<Player> selectAllPlayers() {
        return DB;
    }

    @Override
    public Optional<Player> selectPlayerById(UUID playerId) {
        return DB.stream()
                .filter(player -> player.getPlayerId().equals(playerId))
                .findFirst();
    }

    @Override
    public int deletePlayerById(UUID playerId) {
        Optional<Player> playerMaybe = selectPlayerById(playerId);
        if (playerMaybe.isEmpty()) {
            return 0;
        }

        DB.remove(playerMaybe.get());
        return 1;
    }

    @Override
    public int updatePlayerById(UUID playerId, Player updatedPlayer) {
        return selectPlayerById(playerId)
                .map(player -> {
                    int indexOfPlayerToDelete = DB.indexOf(player);

                    // if the index for that person >= 0, then we know that we've found that person
                    if (indexOfPlayerToDelete >= 0) {
                        DB.set(indexOfPlayerToDelete,
                                new Player(playerId,
                                        updatedPlayer.getTeamId(),
                                        updatedPlayer.getFirstName(),
                                        updatedPlayer.getLastName(),
                                        updatedPlayer.getPosition(),
                                        updatedPlayer.getHeight(),
                                        updatedPlayer.getWeight(),
                                        updatedPlayer.getAge()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
