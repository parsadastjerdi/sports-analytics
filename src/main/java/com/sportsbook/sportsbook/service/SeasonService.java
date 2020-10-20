package com.sportsbook.sportsbook.service;

import com.sportsbook.sportsbook.dao.SeasonDao;
import com.sportsbook.sportsbook.model.Game;
import com.sportsbook.sportsbook.model.Season;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SeasonService {
    private final SeasonDao seasonDao;

    @Autowired
    public SeasonService(@Qualifier("seasonDao") SeasonDao seasonDao) {
        this.seasonDao = seasonDao;
    }

    public int insertSeason(Season season) {
        return seasonDao.insertSeason(season);
    }

    public List<Season> getAllSeasons() {
        return seasonDao.selectAllSeasons();
    }

    public Optional<Season> getSeasonById(UUID seasonId) {
        return seasonDao.selectSeasonById(seasonId);
    }

    public int deleteSeason(UUID seasonId) {
        return seasonDao.deleteSeasonById(seasonId);
    }

    public int updateSeason(UUID seasonId, Season season) {
        return seasonDao.updateSeasonById(seasonId, season);
    }

    public List<Game> getAllGamesInASeason(UUID seasonId) {
        return seasonDao.getAllGamesInASeason(seasonId);
    }
}
