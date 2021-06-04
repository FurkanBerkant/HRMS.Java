package com.kodlamaio.hrms.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BusinessRule {
	public static Result checkPasswordExist(String password, String checkPassword) {
		if (password.equals(checkPassword)) {
			return new SuccessResult();
		}
		return new ErrorResult("Passwords must match");
	}

	public static Result checkEmailDomain(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			return new SuccessResult();
		}
		return new ErrorResult("must be in e-mail format");
	}

	public static boolean checkDate(int startDate,int endDate) {
		if(startDate<=endDate) {
			return true;
		}

		return false;
	}
}
