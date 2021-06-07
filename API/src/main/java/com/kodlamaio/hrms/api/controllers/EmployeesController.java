package com.kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.hrms.business.abstracts.EmployeeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.add(employee));
	}

	@GetMapping("/getall")
	public DataResult<List<Employee>> getAll() {
		return this.employeeService.getAll();
	}
}
