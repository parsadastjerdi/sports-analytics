package com.sportsbook.sportsbook.api;

import com.sportsbook.sportsbook.model.Game;
import com.sportsbook.sportsbook.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/game")
@RestController
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public void insertGame(@Valid @NonNull @RequestBody Game game) {
        gameService.insertGame(game);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    /*
    @GetMapping(path = "{gameId}")
    public Game getGameById(@PathVariable("gameId") UUID gameId) {
        return gameService.getGameById(gameId)
                .orElse(null);
    }
*/

    @DeleteMapping(path = "{gameId}")
    public void deleteGameById(@PathVariable("gameId") UUID gameId) {
        gameService.deleteGame(gameId);
    }

    @PutMapping(path = "{gameId}")
    public void updateGameById(@PathVariable("gameId") UUID gameId,
                               @Valid @NonNull @RequestBody Game game) {
        gameService.updateGame(gameId, game);
    }

    @GetMapping(path = "{pointDifference}")
    public List<Game> getAllGamesWhoseDiffWasLessThanX(
            @PathVariable("pointDifference") Integer pointDifference) {
        return gameService.getAllGamesWhoseDiffWasLessThanX(pointDifference);
    }
}
