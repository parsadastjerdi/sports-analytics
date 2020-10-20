package com.sportsbook.sportsbook.model;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class TeamPlaysGame {
    @NotBlank
    private final UUID homeTeamId;
    @NotBlank
    private final UUID awayTeamId;
    @NotBlank
    private final UUID gameId;
    @NotBlank
    private final Integer homeTeamScore;
    @NotBlank
    private final Integer awayTeamScore;

    public TeamPlaysGame(UUID homeTeamId,
                         UUID awayTeamId,
                         UUID gameId,
                         Integer homeTeamScore,
                         Integer awayTeamScore) {
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.gameId = gameId;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public UUID getHomeTeamId() {
        return homeTeamId;
    }

    public UUID getAwayTeamId() {
        return awayTeamId;
    }

    public UUID getGameId() {
        return gameId;
    }

    public Integer getHomeTeamScore() {
        return homeTeamScore;
    }

    public Integer getAwayTeamScore() {
        return awayTeamScore;
    }
}
