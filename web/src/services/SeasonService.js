import axios from 'axios';

const SEASON_REST_API_URL = 'http://localhost:8080/api/v1/season';

class SeasonService {
    getAllSeasons() {
        return axios.get(SEASON_REST_API_URL);
    }
}

export default new SeasonService();