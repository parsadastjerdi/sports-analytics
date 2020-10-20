package com.sportsbook.sportsbook.api;

import com.sportsbook.sportsbook.model.Coach;
import com.sportsbook.sportsbook.model.Team;
import com.sportsbook.sportsbook.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/team")
@RestController
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public void insertTeam(@Valid @NonNull @RequestBody Team team) {
        teamService.insertTeam(team);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    /*
    @GetMapping(path = "{teamId}")
    public Team getTeamById(@PathVariable("teamId") UUID teamId) {
        return teamService.getTeamById(teamId)
                .orElse(null);
    }
     */

    @DeleteMapping(path = "{teamId}")
    public void deleteTeamById(@PathVariable("teamId") UUID id) {
        teamService.deleteTeam(id);
    }

    @PutMapping(path = "{teamId}")
    public void updateTeam(@PathVariable("teamId") UUID teamId,
                           @Valid @NonNull @RequestBody Team team) {
        teamService.updateTeam(teamId, team);
    }

    @GetMapping(path = "{conference}")
    public List<Coach> getAllCoachesInAConference(@PathVariable("conference") String conference) {
        return teamService.getAllCoachesInAConference(conference);
    }
}
