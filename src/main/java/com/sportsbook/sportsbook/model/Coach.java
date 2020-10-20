package com.sportsbook.sportsbook.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Coach {
    @NotBlank
    private final UUID coachId;
    @NotBlank
    private final String name;
    @NotBlank
    private final Integer age;


    public Coach(@JsonProperty("coachId") UUID coachId,
                 @JsonProperty("name") String name,
                 @JsonProperty("age") Integer age) {
        this.coachId = coachId;
        this.name = name;
        this.age = age;
    }

    public UUID getCoachId() {
        return coachId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
