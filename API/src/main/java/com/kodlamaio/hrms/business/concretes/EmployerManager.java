package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.BusinessRule;
import com.kodlamaio.hrms.business.abstracts.ActivationCodeService;
import com.kodlamaio.hrms.business.abstracts.EmployerService;
import com.kodlamaio.hrms.core.utilities.adapters.abstracts.EmailService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	@Autowired
	private EmployerDao employerDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private EmailService emailService;
	@Autowired
	private ActivationCodeService activationCodeService;
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(), "employers listed.");
	}
	
	@Override
	public Result add(Employer employers) {
		Result result = BusinessRules.run(BusinessRule.checkPasswordExist
				(employers.getPassword(), employers.getPasswordCheck()),
				checkIfEmailExist(employers.getEmail()),
				checkEmailDomain(employers));
		if (result.isSuccess()) {
			employerDao.save(employers);
			activationCodeService.sendVerificationCode(employers.getId());
			sendMail(employers.getEmail(),"your email has been confirmed");
			return new SuccessResult("Successfully added employer");
		}
		return new ErrorResult(result.getMessage());
	}

	private Result checkIfEmailExist(String email) {
		if (!userDao.existsByEmail(email)) {
			return new SuccessResult();
		}
		return new ErrorResult("this email already exists");
	}
	
	private Result checkEmailDomain(Employer employers) {
		try {
			String webSiteName[] = employers.getWebSiteName().split("\\.");
			String regex = "^(.+)@" + webSiteName[1] + "(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(employers.getEmail());
			if (matcher.matches()) {
				return new SuccessResult();
				}
			}
		catch (Exception e) {
			String domain = employers.getWebSiteName();
			if (domain.contains("www.")) {
				domain = domain.substring(4);
				}
			if (employers.getEmail().contains("@"+domain)) {
				return new SuccessResult();
				}
			}
		return new ErrorResult("Email and web adress domains must be same.");
		}
	private void sendMail(String email, String message) {
		emailService.sendMail(email, message);
	}
}
