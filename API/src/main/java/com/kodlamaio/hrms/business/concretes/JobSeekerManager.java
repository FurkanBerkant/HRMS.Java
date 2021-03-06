package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.abstracts.JobSeekerService;
import com.kodlamaio.hrms.core.utilities.adapters.abstracts.EmailService;
import com.kodlamaio.hrms.core.utilities.adapters.abstracts.MernisService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kodlamaio.hrms.dataAccess.abstracts.UserDao;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {
	@Autowired
	private JobSeekerDao jobSeekerDao;
	@Autowired
	private MernisService mernisService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserDao userDao;

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "job seekers list");
	}

	@Override
	public Result add(JobSeeker jobSeekers) {
		Result result = BusinessRules.run(BusinessRules.checkPasswordCharacter(jobSeekers.getPassword()),
				BusinessRules.checkfirstAndLastNameCharacter(jobSeekers.getFirstName(), jobSeekers.getLastName()),
				BusinessRules.checkPasswordExist(jobSeekers.getPassword(), jobSeekers.getPasswordCheck()),
				BusinessRules.checkEmailDomain(jobSeekers.getEmail()), checkIfEmailExist(jobSeekers.getEmail()),
				checkIfIdentityNumberExist(jobSeekers.getIdentityNumber()), checkIfRealPerson(jobSeekers));

		if (result.isSuccess()) {
			jobSeekers = jobSeekerDao.save(jobSeekers);
			sendMail(jobSeekers.getEmail(), "your email has been confirmed");
			mernisService.validate(jobSeekers.getIdentityNumber(), jobSeekers.getFirstName(), jobSeekers.getLastName(),
					jobSeekers.getDateOfBirth());
			return new SuccessResult("you have successfully registered.");
		}
		return new ErrorResult(result.getMessage());
	}

	private Result checkIfEmailExist(String email) {

		if (!userDao.existsByEmail(email)) {
			return new SuccessResult();
		}
		return new ErrorResult("this email is being used");
	}

	private Result checkIfIdentityNumberExist(String identityNumber) {
		if (!jobSeekerDao.existsByIdentityNumber(identityNumber)) {
			return new SuccessResult();
		}
		return new ErrorResult("this id is used.");
	}

	private Result checkIfRealPerson(JobSeeker jobSeeker) {
		if (!this.mernisService.validate(jobSeeker.getIdentityNumber(),
				jobSeeker.getFirstName().toUpperCase(new Locale("tr")),
				jobSeeker.getLastName().toLowerCase(new Locale("tr")), jobSeeker.getDateOfBirth())) {

			return new ErrorResult();
		}
		return new SuccessResult();

	}

	private void sendMail(String email, String message) {
		emailService.sendMail(email, message);
	}

}
