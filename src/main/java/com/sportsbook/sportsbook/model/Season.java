package com.sportsbook.sportsbook.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.UUID;

public class Season {
    @NotBlank
    private final UUID seasonId;
    @NotBlank
    @JsonFormat(pattern = "yyyy-mm-dd")
    private final Date startDate;
    @NotBlank
    @JsonFormat(pattern = "yyyy-mm-dd")
    private final Date endDate;

    public Season(@JsonProperty("seasonId") UUID seasonId,
                  @JsonProperty("startDate") Date startDate,
                  @JsonProperty("endDate") Date endDate) {
        this.seasonId = seasonId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getSeasonId() {
        return seasonId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
