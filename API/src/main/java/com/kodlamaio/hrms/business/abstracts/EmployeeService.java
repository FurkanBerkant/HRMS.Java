package com.kodlamaio.hrms.business.abstracts;

import java.util.List;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeService{
	DataResult<List<Employee>> getAll();
    Result add(Employee employee);
}
