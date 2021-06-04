package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.hrms.business.abstracts.EducationService;
import com.kodlamaio.hrms.core.utilities.business.BusinessRules;
import com.kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import com.kodlamaio.hrms.entities.Dtos.EducationDto;
import com.kodlamaio.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	@Autowired
	private EducationDao educationDao;
	@Autowired
	private DtoConverterService dtoConverterService;

	@Override
	public DataResult<List<EducationDto>> getAll() {
		return new SuccessDataResult<List<EducationDto>>(
				dtoConverterService.dtoConverter(educationDao.findAll(), EducationDto.class), "education listed");
	}

	@Override
	public Result add(EducationDto educationDto) {
		if (BusinessRules.checkDate(educationDto.getStartedDate(), educationDto.getEndedDate())) {
			this.educationDao.save((Education) dtoConverterService.dtoClassConverter(educationDto, Education.class));
			return new SuccessResult("education successfully added");
		}
		return new ErrorResult("enter the date correctly");
	}

}
