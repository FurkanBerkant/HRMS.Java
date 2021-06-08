import axios from '../axios/axios';

export default class EmployeeService {
    getEmployee() {
        return axios.get("/employees/getall")
    }
}
