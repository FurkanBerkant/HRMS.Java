package com.kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.JobTitleService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import com.kodlamaio.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	private final JobTitleDao jobPositionDao;
	@Autowired
	public JobTitleManager(JobTitleDao jobPositionDao) {
		
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>
		(this.jobPositionDao.findAll(),"Is pozisyonları Listelendi.");
    }
	@Override
	public Result add(JobTitle jobPosition) {
	
		if (this.jobPositionDao.existsByPosition(jobPosition.getPosition())) {
			return new ErrorResult("Is pozisyonu mevcut");
		}
		this.jobPositionDao.save(jobPosition);
				return new SuccessResult("iş pozisyonu eklendi");
	}
}