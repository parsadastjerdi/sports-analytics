import axios from 'axios';

const COACH_REST_API_URL = 'http://localhost:8080/api/v1/coach';

class CoachService {
    getAllCoaches() {
        return axios.get(COACH_REST_API_URL);
    }
}

export default new CoachService();