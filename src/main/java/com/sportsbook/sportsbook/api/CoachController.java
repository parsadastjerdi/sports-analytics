package com.sportsbook.sportsbook.api;

import com.sportsbook.sportsbook.model.Coach;
import com.sportsbook.sportsbook.model.Team;
import com.sportsbook.sportsbook.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/coach")
@RestController
public class CoachController {
    private final CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @PostMapping
    public void insertCoach(@Valid @NonNull @RequestBody Coach coach) {
        coachService.insertCoach(coach);
    }

    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.getAllCoaches();
    }

    /*
    @GetMapping(path = "{coachId}")
    public Coach getCoachById(@PathVariable("coachId") UUID coachId) {
        return coachService.getCoachById(coachId)
                .orElse(null);
    }
*/

    @DeleteMapping(path = "{coachId}")
    public void deleteCoachById(@PathVariable("coachId") UUID coachId) {
        coachService.deleteCoach(coachId);
    }

    @PutMapping(path = "{coachId}")
    public void updateCoach(@PathVariable("coachId") UUID coachId,
                            @Valid @NonNull @RequestBody Coach coach) {
        coachService.updateCoach(coachId, coach);
    }

    @GetMapping(path = "{coachId}")
    public List<Team> getAllTeamsForACoach(@PathVariable("coachId") UUID coachId) {
        return coachService.getAllTeamsForACoach(coachId);
    }
}
