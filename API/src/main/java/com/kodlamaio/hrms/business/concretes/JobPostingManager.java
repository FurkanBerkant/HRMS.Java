package com.kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.abstracts.JobPostingService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import com.kodlamaio.hrms.entities.Dtos.JobPostingDto;
import com.kodlamaio.hrms.entities.Dtos.JobPostingRequestDto;
import com.kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {
	@Autowired
	private JobPostingDao jobPostingDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DataResult<List<JobPostingDto>> getAll() {
		List<JobPosting> jobPostings = jobPostingDao.findAllByActiveTrue();
		return new SuccessDataResult<List<JobPostingDto>>(jobPostingToDto(jobPostings),
				"job posting successfully listed");
	}

	@Override
	public Result add(JobPostingRequestDto jobAdvertisementRequestDto) {
		JobPosting jobPosting = modelMapper.map(jobAdvertisementRequestDto, JobPosting.class);
		jobPostingDao.save(jobPosting);
		return new SuccessResult("job posting successfully added");
	}

	@Override
	public DataResult<List<JobPostingDto>> findAllByActiveTrueOrderByCreatedDateDesc() {
		List<JobPosting> jobPostings = jobPostingDao.findAllByActiveTrueOrderByCreatedDateDesc();
		return new SuccessDataResult<List<JobPostingDto>>(jobPostingToDto(jobPostings),
				"job postings successfully sorted by date");
	}

	@Override
	public DataResult<List<JobPostingDto>> findAllByIdAndActiveTrue(int employerId) {
		List<JobPosting> jobAdvertisements = jobPostingDao.findAllByEmployerIdAndActiveTrue(employerId);
		return new SuccessDataResult<List<JobPostingDto>>(jobPostingToDto(jobAdvertisements),
				"job postings sorted by date of employer's job postings");
	}

	@Override
	public DataResult<JobPostingDto> update(int id, boolean active) {
		JobPosting jobPosting = jobPostingDao.findById(id).orElse(null);
		jobPosting.setActive(active);
		return new SuccessDataResult<JobPostingDto>(
				modelMapper.map(jobPostingDao.save(jobPosting), JobPostingDto.class));

	}

	private List<JobPostingDto> jobPostingToDto(List<JobPosting> jobPostings) {
		return jobPostings.stream()
				.map(jobPosting-> modelMapper.map(jobPosting, JobPostingDto.class))
				.collect(Collectors.toList());
	}
}
