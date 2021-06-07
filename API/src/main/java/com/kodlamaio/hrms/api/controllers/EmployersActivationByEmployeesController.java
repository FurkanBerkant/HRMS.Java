package com.kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.hrms.business.abstracts.EmployersActivationByEmployeeService;
import com.kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/employerVerify")
@CrossOrigin
public class EmployersActivationByEmployeesController {

	@Autowired
	private EmployersActivationByEmployeeService employersActivationByEmployeeService;

	@PostMapping("/verify/{employeeId}/{employerId}")
	public Result personelVerify(@RequestParam("employeeId") int employeeId,
			@RequestParam("employerId") int employerId) {
		Result result = employersActivationByEmployeeService.systemVerify(employeeId, employerId);
		return result;
	}
}
