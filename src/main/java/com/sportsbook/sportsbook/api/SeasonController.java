package com.sportsbook.sportsbook.api;

import com.sportsbook.sportsbook.model.Game;
import com.sportsbook.sportsbook.model.Season;
import com.sportsbook.sportsbook.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/season")
@RestController
public class SeasonController {
    private final SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @PostMapping
    public void insertTeam(@Valid @NonNull @RequestBody Season season) {
        seasonService.insertSeason(season);
    }

    @GetMapping
    public List<Season> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    /*
    @GetMapping(path = "{seasonId}")
    public Season getSeasonById(@PathVariable("seasonId") UUID seasonId) {
        return seasonService.getSeasonById(seasonId)
                .orElse(null);
    }
     */

    @DeleteMapping(path = "{seasonId}")
    public void deleteSeasonById(@PathVariable("seasonId") UUID seasonId) {
        seasonService.deleteSeason(seasonId);
    }

    @PutMapping(path = "{seasonId}")
    public void updateSeason(@PathVariable("seasonId") UUID seasonId,
                             @Valid @NonNull @RequestBody Season season) {
        seasonService.updateSeason(seasonId, season);
    }

    @GetMapping(path = "{seasonId}")
    public List<Game> getAllGamesInASeason(@PathVariable("seasonId") UUID seasonId) {
        return seasonService.getAllGamesInASeason(seasonId);
    }
}
