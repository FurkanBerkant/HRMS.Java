package com.kodlamaio.hrms.core.utilities.business;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.entities.concretes.Employer;

public abstract class BusinessRules {

	public static Result run(Result... rules) {
		for (Result rule : rules) {
			if (!rule.isSuccess()) {
				return new ErrorResult(rule.getMessage());
			}
		}
		return new SuccessResult();
	}

	public static Result checkPasswordExist(String password, String checkPassword) {
		if (password.equals(checkPassword)) {
			return new SuccessResult();
		}
		return new ErrorResult("Passwords must match");
	}

	public static Result checkPasswordCharacter(String password) {
		if (password.length() < 6) {
			return new ErrorResult("Password must be at least 6 characters ");
		}
		return new SuccessResult();
	}

	public static Result checkfirstAndLastNameCharacter(String firstName, String lastName) {
		if (firstName.length() < 2 || lastName.length() < 2) {
			return new ErrorResult("First and last name must be at least two characters.");
		}
		return new SuccessResult();
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

	public static boolean checkDate(LocalDate startDate, LocalDate endDate) {
		if (endDate != null) {
			if (!startDate.isBefore(endDate)) {

				return false;
			}

		}

		return true;
	}

	public static Result checkEmployerEmailDomain(Employer employers) {
		try {
			String webSiteName[] = employers.getWebSiteName().split("\\.");
			String regex = "^(.+)@" + webSiteName[1] + "(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(employers.getEmail());
			if (matcher.matches()) {
				return new SuccessResult();
			}
		} catch (Exception e) {
			String domain = employers.getWebSiteName();
			if (domain.contains("www.")) {
				domain = domain.substring(4);
			}
			if (employers.getEmail().contains("@" + domain)) {
				return new SuccessResult();
			}
		}
		return new ErrorResult("Email and web adress domains must be same.");
	}
}
