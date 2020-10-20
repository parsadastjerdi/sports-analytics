import axios from 'axios';

const PLAYER_REST_API_URL = 'http://localhost:8080/api/v1/player';

class PlayerService {
    getAllPlayers() {
        return axios.get(PLAYER_REST_API_URL);
    }

    // need user input on this. also check if this axios function call is correct
    getPlayerById(playerId) {
        return axios.get(PLAYER_REST_API_URL, playerId);
    }
}

export default new PlayerService();