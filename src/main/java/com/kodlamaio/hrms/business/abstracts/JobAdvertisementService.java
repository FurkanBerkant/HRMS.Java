package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.Dtos.JobAdvertisementDto;
import com.kodlamaio.hrms.entities.Dtos.JobAdvertisementRequestDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisementDto>> getAll();
    Result add(JobAdvertisementRequestDto jobAdvertisementRequestDto);
    DataResult<List<JobAdvertisementDto>> findAllByActiveTrueOrderByCreatedDateDesc();
    DataResult<List<JobAdvertisementDto>> findAllByIdAndActiveTrue(int employerId);
    DataResult<JobAdvertisementDto> update(int id,boolean active);
    
}
