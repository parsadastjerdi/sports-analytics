import axios from 'axios';

const GAME_REST_API_URL = 'http://localhost:8080/api/v1/game';

class GameService {
    getAllGames() {
        return axios.get(GAME_REST_API_URL);
    }
}

export default new GameService();