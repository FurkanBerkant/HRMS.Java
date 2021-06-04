package com.kodlamaio.hrms.core.utilities.adapters.abstracts;

import java.time.LocalDate;

public interface MernisService {
	public boolean validate(String nationalityId, String firstName, String lastName, LocalDate date);
}
