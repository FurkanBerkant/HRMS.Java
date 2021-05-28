package com.kodlamaio.hrms.business.concretes;

import java.util.List;
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

	private ActivationCodeDao activationCodeDao;
	
	@Autowired
	public ActivationCodeManager(ActivationCodeDao activationCodeDao) {
		super();
		this.activationCodeDao = activationCodeDao;
	}

	@Override
	public Result sendVerificationCode(int userId) {
		activationCodeDao.save(new ActivationCode(userId, UUID.randomUUID().toString(), false));
		
		return new SuccessResult("Aktivasyon kodu gnderildi.");
		
	}

	@Override
	public Result verify(String code) {
		
		ActivationCode activationCode =activationCodeDao.findByActivationCode(code).orElse(null);
		if (activationCode==null) {
			return new ErrorResult("Dogrulanamadi");
		}
		activationCode.setConfirmed(true);
		activationCodeDao.save(activationCode);
		return new SuccessResult("Kullanici doğrulandi.");
			}
		}


