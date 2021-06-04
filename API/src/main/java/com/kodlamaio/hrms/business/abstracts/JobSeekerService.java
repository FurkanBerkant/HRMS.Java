package com.kodlamaio.hrms.business.abstracts;

import java.util.List;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();

	Result add(JobSeeker jobSeeker);
}
