package com.sportsbook.sportsbook.api;

import com.sportsbook.sportsbook.model.Player;
import com.sportsbook.sportsbook.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/player")
@RestController
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public void addPlayer(@Valid @NonNull @RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    /*
    @GetMapping(path = "{playerId}")
    public Player getPlayerById(@PathVariable("playerId") UUID playerId) {
        return playerService.getPlayerById(playerId)
                .orElse(null);
    }
*/

    @DeleteMapping(path = "{playerId}")
    public void deletePlayerById(@PathVariable("playerId") UUID playerId) {
        playerService.deletePlayer(playerId);
    }

    @PutMapping(path = "{playerId}")
    public void updatePlayerById(@PathVariable("playerId") UUID playerId,
                                 @Valid @NonNull @RequestBody Player player) {
        playerService.updatePlayer(playerId, player);
    }

    @GetMapping(path = "{teamId}")
    public List<Player> getAllPlayersOnATeam(@PathVariable("teamId") UUID teamId) {
        return playerService.getAllPlayersOnATeam(teamId);
    }
}
