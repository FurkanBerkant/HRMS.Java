package com.kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EmployersActivationByEmployeeService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployersActivationByEmployeesDao;
import com.kodlamaio.hrms.entities.concretes.Employee;
import com.kodlamaio.hrms.entities.concretes.Employer;
import com.kodlamaio.hrms.entities.concretes.EmployersActivationByEmployees;
@Service
public class EmployersActivationByEmployeesManager implements EmployersActivationByEmployeeService{
	private EmployersActivationByEmployeesDao employersActivationByEmployeesDao;
	private EmployeeDao employeeDao;
	private EmployerDao employerDao;
	@Autowired
	public EmployersActivationByEmployeesManager(EmployersActivationByEmployeesDao employersActivationByEmployeesDao,EmployeeDao employeeDao,EmployerDao employerDao) {
		super();
		this.employerDao=employerDao;
		this.employeeDao=employeeDao;
		this.employersActivationByEmployeesDao = employersActivationByEmployeesDao;
	}


	@Override
	public Result systemVerify(int employeeId,int employerId) {
		Employee employee=employeeDao.findById(employeeId).orElse(null);
		Employer employer =employerDao.findById(employerId).orElse(null);
		Result result = BusinessRules.run
				(existsByEmployerIdAndEmployeeId(employeeId, employerId));
		if(employer==null) {
			return new ErrorResult(" is veren onaylanmadı");
		}
		else if(employee==null)
		{
			return new ErrorResult("sistem personeli onaylanmadı");
		}
		else if(result.isSuccess())
		{
		EmployersActivationByEmployees employersActivationByEmployees=new EmployersActivationByEmployees();
		employersActivationByEmployees.setConfirmed(true);
		employersActivationByEmployees.setEmployer(employer);
		employersActivationByEmployees.setEmployee(employee);
		employersActivationByEmployeesDao.save(employersActivationByEmployees);
		return new SuccessResult("sistem personeli basariyla isvereni onayladi");
		}
		return new ErrorResult("onaylanmis");
	}
	
	public Result existsByEmployerIdAndEmployeeId(int employeeId,int employerId) {

		if (!employersActivationByEmployeesDao
				.existsByEmployerIdAndEmployeeId(employerId,employeeId)) {
			return new SuccessResult();
		}
		return new ErrorResult("onaylanmıs");
	}
}
