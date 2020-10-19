package com.sportsbook.sportsbook.service;

import com.sportsbook.sportsbook.dao.TeamDao;
import com.sportsbook.sportsbook.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeamService {

    private final TeamDao teamDao;

    @Autowired
    public TeamService(@Qualifier("teamDao") TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public int insertTeam(Team team) {
        return teamDao.insertTeam(team);
    }

    public List<Team> getAllTeams() {
        return teamDao.selectAllTeams();
    }

    public Optional<Team> getTeamById(UUID id) {
        return teamDao.selectTeamById(id);
    }

    public int deleteTeam(UUID id) {
        return teamDao.deleteTeamById(id);
    }

    public int updateTeam(UUID id, Team team) {
        return teamDao.updateTeamById(id, team);
    }

}