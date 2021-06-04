package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.Dtos.JobPostingGetDto;
import com.kodlamaio.hrms.entities.Dtos.JobPostingPostDto;

public interface JobPostingService {
	DataResult<List<JobPostingGetDto>> getAll();

	Result add(JobPostingPostDto jobAdvertisementRequestDto);

	DataResult<List<JobPostingGetDto>> findAllByActiveTrueOrderByCreatedDateDesc();

	DataResult<List<JobPostingGetDto>> findAllByIdAndActiveTrue(int employerId);

	DataResult<JobPostingGetDto> update(int id, boolean activate);

}
