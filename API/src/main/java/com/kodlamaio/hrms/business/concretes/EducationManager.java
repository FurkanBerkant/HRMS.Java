package com.kodlamaio.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.abstracts.EducationService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import com.kodlamaio.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService{

	@Autowired
	private EducationDao educationDao;

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>
		(this.educationDao.findAll(),"educations listed successfully");
	}

	@Override
	public Result add(Education education) {
		this.educationDao.save(education);
		return new SuccessResult("education successfully added");
	}
}
