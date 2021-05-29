package com.kodlamaio.hrms.business.abstracts;

import com.kodlamaio.hrms.core.utilities.results.Result;

public interface EmployersActivationByEmployeeService {

	Result systemVerify(int employerId,int employeeId);
}
