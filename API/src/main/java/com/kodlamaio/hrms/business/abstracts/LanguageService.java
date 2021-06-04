package com.kodlamaio.hrms.business.abstracts;

import java.util.List;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.Dtos.LanguageDto;

public interface LanguageService {
	DataResult<List<LanguageDto>> getAll();

	Result add(LanguageDto languageDto);
}
