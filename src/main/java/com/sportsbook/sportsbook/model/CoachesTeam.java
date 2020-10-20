package com.sportsbook.sportsbook.model;

import java.sql.Date;
import java.util.UUID;

public class CoachesTeam {
    private final UUID coachId;
    private final UUID teamId;
    private final Date startDate;
    private final Date endDate;


    public CoachesTeam(UUID coachId, UUID teamId, Date startDate, Date endDate) {
        this.coachId = coachId;
        this.teamId = teamId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getCoachId() {
        return coachId;
    }

    public UUID getTeamId() {
        return teamId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
