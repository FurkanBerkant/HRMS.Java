package com.kodlamaio.hrms.business.concretes;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.abstracts.TechnologyService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import com.kodlamaio.hrms.entities.Dtos.TechnologyDto;
import com.kodlamaio.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService{
	@Autowired
	private ModelMapper modelMapper;
	@Autowired 
	private TechnologyDao technologyDao;
	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>
		(this.technologyDao.findAll(),"technologies listed successfully");
	}

	@Override
	public Result add(TechnologyDto technologyDto) {
		Technology technology=modelMapper.map(technologyDto, Technology.class);
		this.technologyDao.save(technology);
		return new SuccessResult("technology successfully added");
	}
}
