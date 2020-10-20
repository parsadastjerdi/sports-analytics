import axios from 'axios';

const ALL_COACHES_IN_CONF = 'http://localhost:8080/api/v1/team';
const ALL_PLAYERS_ON_X_TEAM = 'http://localhost:8080/api/v1/player';
const ALL_GAMES_LESS_DIFF = 'http://localhost:8080/api/v1/game';
const ALL_GAMES_IN_SEASON_X = 'http://localhost:8080/api/v1/season';
const ALL_TEAMS_WITH_COACH = 'http://localhost:8080/api/v1/coach';

class QueriesService {
    getAllCoachesInAConference(conference) {
        return axios.get(ALL_COACHES_IN_CONF, conference);
    }

    getAllPlayersWhoPlayedOnXTeam(teamId) {
        return axios.get(ALL_PLAYERS_ON_X_TEAM, teamId);
    }

    getAllGamesWhoseDifferenceIsLessThanX(pointDifference) {
        return axios.get(ALL_GAMES_LESS_DIFF, pointDifference);
    }

    getAllGamesInSeasonX(seasonId) {
        return axios.get(ALL_GAMES_IN_SEASON_X, seasonId);
    }

    getAllTeamsWhoHavePlayedForAGivenCoach(coachId) {
        return axios.get(ALL_TEAMS_WITH_COACH, coachId);
    }
}

export default new QueriesService();