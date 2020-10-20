package com.sportsbook.sportsbook.dao;

import com.sportsbook.sportsbook.model.Game;
import com.sportsbook.sportsbook.model.Season;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SeasonDao {
    int insertSeason(UUID seasonId, Season season);

    default int insertSeason(Season season) {
        UUID id = UUID.randomUUID();
        return insertSeason(id, season);
    }

    List<Season> selectAllSeasons();

    Optional<Season> selectSeasonById(UUID seasonId);

    int deleteSeasonById(UUID seasonId);

    int updateSeasonById(UUID seasonId, Season season);

    List<Game> getAllGamesInASeason(UUID seasonId);
}
