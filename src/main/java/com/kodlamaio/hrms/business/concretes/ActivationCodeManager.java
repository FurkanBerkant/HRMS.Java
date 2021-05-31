package com.kodlamaio.hrms.business.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.ActivationCodeService;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import com.kodlamaio.hrms.entities.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService{

	@Autowired
	private ActivationCodeDao activationCodeDao;
	

	@Override
	public Result sendVerificationCode(int userId) {
		activationCodeDao.save(new ActivationCode(userId, UUID.randomUUID().toString(), false));
		
		return new SuccessResult("activation code sent.");
		
	}

	@Override
	public Result verify(String code) {
		
		ActivationCode activationCode =activationCodeDao.findByActivationCode(code).orElse(null);
		if (activationCode==null) {
			return new ErrorResult("user could not be verified");
		}
		activationCode.setConfirmed(true);
		activationCodeDao.save(activationCode);
		return new SuccessResult("user verified.");

}

	
		
}


