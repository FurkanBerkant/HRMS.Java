import axios from '../axios/axios';
export default class ResumeService {
    getResumes() {
        return axios.get("/resumes/getall")
    }
}