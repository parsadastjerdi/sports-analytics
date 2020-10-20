package com.sportsbook.sportsbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.UUID;

public class PlaysForTeam {
    @NotBlank
    private final UUID playerId;
    @NotBlank
    private final UUID gameId;
    @NotBlank
    private final Date startDate;
    @NotBlank
    private final Date endDate;

    public PlaysForTeam(@JsonProperty("playerId") UUID playerId,
                        @JsonProperty("gameId") UUID gameId,
                        @JsonProperty("startDate") Date startDate,
                        @JsonProperty("endDate") Date endDate) {
        this.playerId = playerId;
        this.gameId = gameId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public UUID getGameId() {
        return gameId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
