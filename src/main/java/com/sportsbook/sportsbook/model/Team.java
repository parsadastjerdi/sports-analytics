package com.sportsbook.sportsbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Team {
    private final UUID teamId;
    @NotBlank
    private final String name;
    @NotBlank
    private final String city;
    @NotBlank
    private final String conference;

    public Team(@JsonProperty("teamId") UUID teamId,
                @JsonProperty("name") String name,
                @NotBlank String city,
                @NotBlank String conference) {
        this.teamId = teamId;
        this.name = name;
        this.city = city;
        this.conference = conference;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public String getCity() { return city; }

    public String getConference() { return conference; }
}
