package com.sportsbook.sportsbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Player {
    @NotBlank
    private final UUID playerId;
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    @NotBlank
    private final String position;
    @NotBlank
    private final Integer height;
    @NotBlank
    private final Integer weight;
    @NotBlank
    private final Integer age;

    public Player(@JsonProperty("playerId") UUID playerId,
                  @JsonProperty("firstName") String firstName,
                  @JsonProperty("lastName") String lastName,
                  @JsonProperty("position") String position,
                  @JsonProperty("height") Integer height,
                  @JsonProperty("weight") Integer weight,
                  @JsonProperty("age") Integer age) {
        this.playerId = playerId;
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getAge() {
        return age;
    }
}
