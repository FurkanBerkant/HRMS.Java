package com.kodlamaio.hrms.business.abstracts;
import java.util.List;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.Dtos.EducationDto;
import com.kodlamaio.hrms.entities.concretes.Education;

public interface EducationService {
	DataResult<List<EducationDto>> getAll();
    Result add(EducationDto educationDto);
}
