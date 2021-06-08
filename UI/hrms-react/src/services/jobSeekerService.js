import axios from '../axios/axios';
export default class JobSeekerService {
    getJobSeekers() {
        return axios.get("/jobseekers/getall")
    }
}