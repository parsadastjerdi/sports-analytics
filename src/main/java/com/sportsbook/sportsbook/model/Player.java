package com.sportsbook.sportsbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Player {
    private final UUID playerId;
    private final UUID teamId; // should be one to many

    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    @NotBlank
    private final String position;
    @NotBlank
    private final String height;
    @NotBlank
    private final String weight;
    @NotBlank
    private final Integer age;

    public Player(@JsonProperty("playerId") UUID playerId,
                  @JsonProperty("teamId") UUID teamId,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("position") String position,
                  @JsonProperty("height") String height,
                  @JsonProperty("weight") String weight,
                  @JsonProperty("age") Integer age) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public Integer getAge() {
        return age;
    }
}
