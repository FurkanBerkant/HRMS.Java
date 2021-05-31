package com.kodlamaio.hrms.business;

import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BusinessRule {
	public static Result checkPasswordExist(String password,String checkPassword) {
		if(password.equals(checkPassword)) {
			return new SuccessResult();
		}
		return new ErrorResult("Passwords must match");
	}
	
}
