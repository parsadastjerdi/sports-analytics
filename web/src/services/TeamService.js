import axios from 'axios';

const TEAM_REST_API_URL = 'http://localhost:8080/api/v1/team';

class TeamService {
    getAllTeams() {
        return axios.get(TEAM_REST_API_URL);
    }
}

export default new TeamService();