package com.sportsbook.sportsbook.api;

import com.sportsbook.sportsbook.model.Team;
import com.sportsbook.sportsbook.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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

    @GetMapping(path = "{id}")
    public Team getTeamById(@PathVariable("id") UUID id) {
        return teamService.getTeamById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteTeamById(@PathVariable("id") UUID id) {
        teamService.deleteTeam(id);
    }

    @PutMapping(path = "{id}")
    public void updateTeam(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Team team) {
        teamService.updateTeam(id, team);
    }
}
