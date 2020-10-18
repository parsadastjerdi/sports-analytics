package com.sportsbook.sportsbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

// TODO: replace explicit constructor and getters/setters with lombok
public class Player {
    private final UUID playerId;
    private final UUID teamId; // should be one to many
    // @NotBlank not showing up here
    private final String firstName;
    private final String lastName;
    private final String position;
    private final String height;
    private final String weight;
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
