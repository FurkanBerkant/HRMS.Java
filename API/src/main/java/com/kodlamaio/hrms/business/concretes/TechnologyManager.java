package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.abstracts.TechnologyService;
import com.kodlamaio.hrms.core.utilities.dtoConverter.abstracts.DtoConverterService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import com.kodlamaio.hrms.entities.Dtos.TechnologyDto;
import com.kodlamaio.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	@Autowired
	private DtoConverterService dtoConverterService;
	@Autowired
	private TechnologyDao technologyDao;

	@Override
	public DataResult<List<TechnologyDto>> getAll() {
		return new SuccessDataResult<List<TechnologyDto>>(
				dtoConverterService.dtoConverter(technologyDao.findAll(), TechnologyDto.class),
				"technologies listed successfully");
	}

	@Override
	public Result add(TechnologyDto technologyDto) {
		technologyDao.save((Technology) dtoConverterService.dtoClassConverter(technologyDto, Technology.class));
		return new SuccessResult("technology successfully added");
	}
}
