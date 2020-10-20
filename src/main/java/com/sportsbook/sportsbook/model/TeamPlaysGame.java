package com.sportsbook.sportsbook.model;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class TeamPlaysGame {
    @NotBlank
    private final UUID teamId;
    @NotBlank
    private final UUID gameId;
    @NotBlank
    private final Integer homeTeamScore;
    @NotBlank
    private final Integer awayTeamScore;

    public TeamPlaysGame(UUID teamId,
                         UUID gameId,
                         Integer homeTeamScore,
                         Integer awayTeamScore) {
        this.teamId = teamId;
        this.gameId = gameId;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
    }

    public UUID getHomeTeamId() {
        return teamId;
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
