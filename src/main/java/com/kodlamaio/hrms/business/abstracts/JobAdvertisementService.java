package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.Dtos.JobPostingDto;
import com.kodlamaio.hrms.entities.Dtos.JobPostingRequestDto;

public interface JobAdvertisementService {
	DataResult<List<JobPostingDto>> getAll();
    Result add(JobPostingRequestDto jobAdvertisementRequestDto);
    DataResult<List<JobPostingDto>> findAllByActiveTrueOrderByCreatedDateDesc();
    DataResult<List<JobPostingDto>> findAllByIdAndActiveTrue(int employerId);
    DataResult<JobPostingDto> update(int id,boolean activate);
    
}
