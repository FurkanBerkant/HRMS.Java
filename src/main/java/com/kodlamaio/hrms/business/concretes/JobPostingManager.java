package com.kodlamaio.hrms.business.concretes;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import com.kodlamaio.hrms.core.utilities.results.SuccessResult;
import com.kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import com.kodlamaio.hrms.entities.Dtos.JobPostingDto;
import com.kodlamaio.hrms.entities.Dtos.JobPostingRequestDto;
import com.kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobAdvertisementService {
	@Autowired
	private JobPostingDao jobAdvertisementDao;
	@Autowired
	private ModelMapper modelMapper;


	@Override
	public DataResult<List<JobPostingDto>> getAll() {
		List<JobPosting> jobAdvertisements=jobAdvertisementDao.findAllByActiveTrue();
		return new SuccessDataResult<List<JobPostingDto>>
		(jobAdvertisementToDto(jobAdvertisements),"job posting successfully listed");
	}
	@Override
	public Result add(JobPostingRequestDto jobAdvertisementRequestDto) {
		JobPosting jobAdvertisement2 = modelMapper.map(jobAdvertisementRequestDto, 
																JobPosting.class);
		jobAdvertisementDao.save(jobAdvertisement2);
		return new SuccessResult("job posting successfully added");
	}
	@Override
	public DataResult<List<JobPostingDto>> findAllByActiveTrueOrderByCreatedDateDesc() {
		List<JobPosting> jobAdvertisements=jobAdvertisementDao
				.findAllByActiveTrueOrderByCreatedDateDesc();
		return new SuccessDataResult<List<JobPostingDto>>
		(jobAdvertisementToDto(jobAdvertisements),
				"job postings successfully sorted by date");
	}
	@Override
	public DataResult<List<JobPostingDto>> findAllByIdAndActiveTrue(int employerId) {
		List<JobPosting> jobAdvertisements=jobAdvertisementDao
				.findAllByEmployerIdAndActiveTrue(employerId);
		return new SuccessDataResult<List<JobPostingDto>>
		(jobAdvertisementToDto(jobAdvertisements),
				"job postings sorted by date of employer's job postings");
	}


	@Override
	public DataResult<JobPostingDto> update(int id,boolean active) {
		JobPosting jobAdvertisement=jobAdvertisementDao.findById(id).orElse(null);
		jobAdvertisement.setActive(active);
		return new SuccessDataResult<JobPostingDto>
		(modelMapper.map(jobAdvertisementDao.save(jobAdvertisement),JobPostingDto.class));

	}
	private List<JobPostingDto> jobAdvertisementToDto
									   (List<JobPosting> jobAdvertisements){		
		return jobAdvertisements.stream()
		.map(jobAdvertisement->modelMapper.map(jobAdvertisement,JobPostingDto.class))
		.collect(Collectors.toList());
	}
}
