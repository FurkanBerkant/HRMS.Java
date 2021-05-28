package com.kodlamaio.hrms.core.utilities.adapters.abstracts;

import java.sql.Date;
public interface MernisService {
	public boolean validate(String nationalityId, String firstName, String lastName, Date date);
}
