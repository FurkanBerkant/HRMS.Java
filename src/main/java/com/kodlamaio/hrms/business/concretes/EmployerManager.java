package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EmployerService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import com.kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {
	private EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Is verenler Listelendi");

	}

	@Override
	public Result add(Employer employers) {
		Result result = BusinessRules.run(
				checkAllFields(employers), 
				checkIfEmailExist(employers.getEmail()),
				checkEmailDomain(employers));
		if (result.isSuccess()) {
			employerDao.save(employers);
			return new SuccessResult();
		}
		return new ErrorResult(result.getMessage());
	}

	public Result checkAllFields(Employer employers) {
		if (employers.getEmail().isEmpty() || employers.getPassword().isEmpty() || employers.getPhone().isEmpty()
				||employers.getWebSiteName().isEmpty()) {
			return new ErrorResult("bilgiler bos birakilamaz.");
		}

		return new SuccessResult();

	}

	public Result checkIfEmailExist(String email) {

		if (!employerDao.existsByEmail(email)) {
			return new SuccessResult();
		}
		return new ErrorResult("Bu email kullanimda");
	}

	public Result checkEmailDomain(Employer employers) {
		try {
			String webSiteName[] = employers.getWebSiteName().split("\\.");
			String regex = "^(.+)@" + webSiteName[1] + "(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(employers.getEmail());
			if (matcher.matches()) {
				return new SuccessResult();
				}
			return new ErrorResult("email adresinizi lutfen dogru giriniz");
		}
		catch (Exception e) {
			String domain = employers.getWebSiteName();
			if (domain.contains("www.")) {
				domain = domain.substring(4);
			}
			
			if (employers.getEmail().contains("@"+domain)) {
				return new SuccessResult();
			}
			return new ErrorResult("Email and web adress domains must be same.");
		}
		

	}
}
