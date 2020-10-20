package com.sportsbook.sportsbook.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.UUID;

public class Game {
    @NotBlank
    private final UUID gameId;
    @NotBlank
    private final UUID seasonId;
    @NotBlank
    private final String venue;
    @NotBlank
    @JsonFormat(pattern = "yyyy-mm-dd")
    private final Date gameDate;

    public Game(@JsonProperty("gameId") UUID gameId,
                @JsonProperty("seasonId") UUID seasonId,
                @JsonProperty("venue") String venue,
                @JsonProperty("gameDate") Date gameDate) {
        this.gameId = gameId;
        this.seasonId = seasonId;
        this.venue = venue;
        this.gameDate = gameDate;
    }

    public UUID getGameId() {
        return gameId;
    }

    public UUID getSeasonId() {
        return seasonId;
    }

    public String getVenue() {
        return venue;
    }

    public Date getGameDate() {
        return gameDate;
    }
}
