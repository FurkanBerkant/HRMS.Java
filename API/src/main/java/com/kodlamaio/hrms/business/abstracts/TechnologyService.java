package com.kodlamaio.hrms.business.abstracts;
import java.util.List;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.Dtos.TechnologyDto;
import com.kodlamaio.hrms.entities.concretes.Technology;

public interface TechnologyService {
	DataResult<List<Technology>> getAll();
    Result add(TechnologyDto technologyDto);
}
