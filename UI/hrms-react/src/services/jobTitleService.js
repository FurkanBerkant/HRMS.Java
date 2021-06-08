import axios from '../axios/axios';
export default class JobTitleService {
    getJobTitles() {
        return axios.get("/position/getall")
    }
}