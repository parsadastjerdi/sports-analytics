package com.sportsbook.sportsbook.service;

import com.sportsbook.sportsbook.dao.CoachDao;
import com.sportsbook.sportsbook.model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoachService {
    private final CoachDao coachDao;

    @Autowired
    public CoachService(@Qualifier("coachDao") CoachDao coachDao) {
        this.coachDao = coachDao;
    }

    public int insertCoach(Coach coach) {
        return coachDao.insertCoach(coach);
    }

    public List<Coach> getAllCoaches() {
        return coachDao.selectAllCoaches();
    }

    public Optional<Coach> getCoachById(UUID coachId) {
        return coachDao.selectCoachById(coachId);
    }

    public int deleteCoach(UUID coachId) {
        return coachDao.deleteCoachById(coachId);
    }

    public int updateCoach(UUID coachId, Coach coach) {
        return coachDao.updateCoachById(coachId, coach);
    }
}
