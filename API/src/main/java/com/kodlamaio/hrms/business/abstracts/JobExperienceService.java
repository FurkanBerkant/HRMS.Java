package com.kodlamaio.hrms.business.abstracts;

import java.util.List;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.Dtos.JobExperienceDto;

public interface JobExperienceService {
	DataResult<List<JobExperienceDto>> getAll();

	Result add(JobExperienceDto jobExperienceDto);

	DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id);
}
