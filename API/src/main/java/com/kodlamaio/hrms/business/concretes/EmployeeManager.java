package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.BusinessRule;
import com.kodlamaio.hrms.business.abstracts.EmployeeService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	@Autowired
	private UserDao userDao;

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), "system personnel listed");

	}

	@Override
	public Result add(Employee employee) {
		Result result = BusinessRules.run(
				BusinessRule.checkPasswordExist(employee.getPassword(), employee.getPasswordCheck()),
				checkIfEmailExists(employee.getEmail()), BusinessRule.checkEmailDomain(employee.getEmail()));
		if (result.isSuccess()) {
			employeeDao.save(employee);
			return new SuccessResult("successfully added system personnel");
		}
		return new ErrorResult(result.getMessage());
	}

	private Result checkIfEmailExists(String email) {
		if (!userDao.existsByEmail(email)) {
			return new SuccessResult();
		}
		return new ErrorResult("this email already exists");
	}

}
