package com.sportsbook.sportsbook.model;

import java.util.UUID;

public class GamesInSeason {
    private final UUID gameId;
    private final UUID seasonId;

    public GamesInSeason(UUID gameId, UUID seasonId) {
        this.gameId = gameId;
        this.seasonId = seasonId;
    }

    public UUID getGameId() {
        return gameId;
    }

    public UUID getSeasonId() {
        return seasonId;
    }
}
