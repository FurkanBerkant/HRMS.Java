package com.kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.ActivationCodeService;
import com.kodlamaio.hrms.business.abstracts.EmployersActivationByEmployeeService;
import com.kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activation")
public class ActivationCodesController {
	
	private ActivationCodeService activationCodeService;
	
	@Autowired
	public ActivationCodesController(ActivationCodeService activationCodeService) {
		super();
		this.activationCodeService = activationCodeService;
	}


	@PostMapping("/verify/{activationCode}")
	public Result verify(@RequestParam("activationCode") String code) {
		Result result = activationCodeService.verify(code);
		
		return result;
	}
	
}
