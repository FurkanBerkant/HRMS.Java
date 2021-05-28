package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.ActivationCodeService;
import com.kodlamaio.hrms.business.abstracts.JobSeekerService;
import com.kodlamaio.hrms.core.utilities.adapters.abstracts.MernisService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private MernisService mernisService;
	private ActivationCodeService activationCodeService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,MernisService mernisService,ActivationCodeService activationCodeService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisService=mernisService;
		this.activationCodeService=activationCodeService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobSeeker jobSeekers) {
		Result result=BusinessRules.run(
				checkAllFields(jobSeekers),
				checkIfEmailExist(jobSeekers.getEmail()),
				checkIfIdentityNumberExist(jobSeekers.getIdentityNumber()),
				checkIfRealPerson(jobSeekers));
		
		if(result.isSuccess()) {
			jobSeekers=jobSeekerDao.save(jobSeekers);
			activationCodeService.sendVerificationCode(jobSeekers.getId());
			return new SuccessResult("Basariyla Kaydoldunuz.");
		}
		return new ErrorResult(result.getMessage());
	}
	

	
	public Result checkAllFields(JobSeeker jobSeekers) {
		if (jobSeekers.getFirstName().isEmpty()|| jobSeekers.getLastName().isEmpty() ||
        		jobSeekers.getIdentityNumber().isEmpty()) {
			return new ErrorResult("bilgiler bos birakilamaz.");
			}
		
		return new SuccessResult();
		
	}
	
	public Result checkIfEmailExist(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
		if(matcher.matches()&&!jobSeekerDao.existsByEmail(email)) {
			return new SuccessResult();
		}
		return new ErrorResult("Bu email kullanimda");
	}
	
	public Result checkIfIdentityNumberExist(String identityNumber) {
		if(!jobSeekerDao.existsByIdentityNumber(identityNumber))
		{
			if(identityNumber.length()==11) {
				return new SuccessResult();
			}
			else {
				return new ErrorResult("tcNo 11 karakter olmalıdır.");
			}
		}
		return new ErrorResult("Bu tcNo kullanimda.");
	}
	
	private Result checkIfRealPerson(JobSeeker jobSeeker) {
		   if(!this.mernisService.validate(jobSeeker.getIdentityNumber(), 
						   jobSeeker.getFirstName().toUpperCase(new Locale("tr")), 
						   jobSeeker.getLastName().toLowerCase(new Locale("tr")),
				   jobSeeker.getDate())) {
			   
			   return new ErrorResult();
		   }
		   return new SuccessResult();
			
		}
}

