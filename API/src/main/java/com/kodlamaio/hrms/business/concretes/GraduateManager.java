package com.kodlamaio.hrms.business.concretes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.abstracts.GraduateService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.GraduateDao;
import com.kodlamaio.hrms.entities.concretes.Graduate;

@Service
public class GraduateManager implements GraduateService{
	@Autowired
	private GraduateDao graduateDao;
	
	@Override
	public DataResult<List<Graduate>> getAll() {
		return new SuccessDataResult<List<Graduate>>
		(this.graduateDao.findAll(),"listelendi");
	}

	@Override
	public Result add(Graduate graduate) {
		Result result =BusinessRules.run(checkIfDescriptionExist(graduate.getDescription()));
		if(result.isSuccess()) {
			this.graduateDao.save(graduate);
		return new SuccessResult("Successfully added description");
		}
		return new ErrorResult(result.getMessage());

	}
	
	private Result checkIfDescriptionExist(String description) {
		if (!graduateDao.existsByDescription(description)) {
			return new SuccessResult();
		}
		return new ErrorResult("this email already exists");
	}

}
