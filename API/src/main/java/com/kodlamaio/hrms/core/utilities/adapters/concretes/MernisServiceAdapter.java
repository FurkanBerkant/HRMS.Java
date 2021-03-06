package com.kodlamaio.hrms.core.utilities.adapters.concretes;

import java.time.LocalDate;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.core.utilities.adapters.abstracts.MernisService;
import com.kodlamaio.hrms.mernisService.fakeMernisService.FakeMernisService;

@Service
public class MernisServiceAdapter implements MernisService {

	@Override
	public boolean validate(String nationalityId, String firstName, String lastName, LocalDate date) {
		FakeMernisService client = new FakeMernisService();
		boolean result = client.TCKimlikDogrula(nationalityId, firstName, lastName, date);
		return result;
	}

}
