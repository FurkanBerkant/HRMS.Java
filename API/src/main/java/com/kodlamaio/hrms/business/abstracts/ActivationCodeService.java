package com.kodlamaio.hrms.business.abstracts;
import com.kodlamaio.hrms.core.utilities.results.Result;

public interface ActivationCodeService {
	Result sendVerificationCode(int userId);
	Result verify(String code);
}
