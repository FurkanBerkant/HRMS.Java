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
import com.kodlamaio.hrms.entities.Dtos.JobPostingGetDto;
import com.kodlamaio.hrms.entities.Dtos.JobPostingPostDto;
import com.kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {
	@Autowired
	private JobPostingDao jobPostingDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DataResult<List<JobPostingGetDto>> getAll() {
		List<JobPosting> jobPostings = jobPostingDao.findAllByActiveTrue();
		return new SuccessDataResult<List<JobPostingGetDto>>(jobPostingToDto(jobPostings),
				"job posting successfully listed");
	}

	@Override
	public Result add(JobPostingPostDto jobAdvertisementRequestDto) {
		JobPosting jobPosting = modelMapper.map(jobAdvertisementRequestDto, JobPosting.class);
		jobPostingDao.save(jobPosting);
		return new SuccessResult("job posting successfully added");
	}

	@Override
	public DataResult<List<JobPostingGetDto>> findAllByActiveTrueOrderByCreatedDateDesc() {
		List<JobPosting> jobPostings = jobPostingDao.findAllByActiveTrueOrderByCreatedDateDesc();
		return new SuccessDataResult<List<JobPostingGetDto>>(jobPostingToDto(jobPostings),
				"job postings successfully sorted by date");
	}

	@Override
	public DataResult<List<JobPostingGetDto>> findAllByIdAndActiveTrue(int employerId) {
		List<JobPosting> jobAdvertisements = jobPostingDao.findAllByEmployerIdAndActiveTrue(employerId);
		return new SuccessDataResult<List<JobPostingGetDto>>(jobPostingToDto(jobAdvertisements),
				"job postings sorted by date of employer's job postings");
	}

	@Override
	public DataResult<JobPostingGetDto> update(int id, boolean active) {
		JobPosting jobPosting = jobPostingDao.findById(id).orElse(null);
		jobPosting.setActive(active);
		return new SuccessDataResult<JobPostingGetDto>(
				modelMapper.map(jobPostingDao.save(jobPosting), JobPostingGetDto.class));

	}

	private List<JobPostingGetDto> jobPostingToDto(List<JobPosting> jobPostings) {
		return jobPostings.stream()
				.map(jobPosting-> modelMapper.map(jobPosting, JobPostingGetDto.class))
				.collect(Collectors.toList());
	}
}
