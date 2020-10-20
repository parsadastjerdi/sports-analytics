import axios from 'axios';

const PLAYER_REST_API_URL = 'http://localhost:8080/api/v1/player';

class PlayerService {
    getAllPlayers() {
        return axios.get(PLAYER_REST_API_URL);
    }
}

export default new PlayerService();