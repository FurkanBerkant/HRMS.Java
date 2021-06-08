import axios from '../axios/axios';

export default class JobPostingService {
    getJobPosting() {
        return axios.get("/JobAdvertisement/getall")
    }
}
