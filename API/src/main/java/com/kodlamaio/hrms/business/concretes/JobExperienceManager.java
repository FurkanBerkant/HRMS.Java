package com.kodlamaio.hrms.business.concretes;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.abstracts.JobExperienceService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import com.kodlamaio.hrms.entities.Dtos.JobExperienceDto;
import com.kodlamaio.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private JobExperienceDao jobExperienceDao;
	@Override
	public DataResult<List<JobExperience>> getAll() {
		return new SuccessDataResult<List<JobExperience>>
		(this.jobExperienceDao.findAll(),"jobExperiences listed successfully");
	}

	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		JobExperience jobExperience=modelMapper.map(jobExperienceDto, JobExperience.class);
		this.jobExperienceDao.save(jobExperience);
		return new SuccessResult("jobExperience successfully added");
	}
}
