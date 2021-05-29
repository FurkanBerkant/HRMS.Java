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
import com.kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.kodlamaio.hrms.entities.Dtos.JobAdvertisementDto;
import com.kodlamaio.hrms.entities.Dtos.JobAdvertisementRequestDto;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	private JobAdvertisementDao jobAdvertisementDao;
	private ModelMapper modelMapper;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,ModelMapper modelMapper) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.modelMapper=modelMapper;
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> getAll() {
		List<JobAdvertisement> jobAdvertisements=jobAdvertisementDao.findAllByActiveTrue();
	
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(jobAdvertisementToDto(jobAdvertisements),"Basariyla listelendi");
	}

	@Override
	public Result add(JobAdvertisementRequestDto jobAdvertisementRequestDto) {
		JobAdvertisement jobAdvertisement2 = modelMapper.map(jobAdvertisementRequestDto, JobAdvertisement.class);
		jobAdvertisementDao.save(jobAdvertisement2);
		return new SuccessResult("basariyla is ilanı eklendi");
	}


	@Override
	public DataResult<List<JobAdvertisementDto>> findAllByActiveTrueOrderByCreatedDateDesc() {
		List<JobAdvertisement> jobAdvertisements=jobAdvertisementDao.findAllByActiveTrueOrderByCreatedDateDesc();
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(jobAdvertisementToDto(jobAdvertisements),"Basariyla tarihe gore siralandi listelendi");
	
	}
	@Override
	public DataResult<List<JobAdvertisementDto>> findAllByIdAndActiveTrue(int employerId) {
		List<JobAdvertisement> jobAdvertisements=jobAdvertisementDao.findAllByEmployerIdAndActiveTrue(employerId);
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(jobAdvertisementToDto(jobAdvertisements),"Basariyla tarihe gore siralandi listelendi");
	}


	@Override
	public DataResult<JobAdvertisementDto> update(int id,boolean active) {
		JobAdvertisement jobAdvertisement=jobAdvertisementDao.findById(id).orElse(null);
		jobAdvertisement.setActive(active);
		return new SuccessDataResult<JobAdvertisementDto>
		(modelMapper.map(jobAdvertisementDao.save(jobAdvertisement), JobAdvertisementDto.class));

	}
	private List<JobAdvertisementDto> jobAdvertisementToDto(List<JobAdvertisement> jobAdvertisements){		
		return jobAdvertisements.stream()
		.map(jobAdvertisement->modelMapper.map(jobAdvertisement,JobAdvertisementDto.class))
		.collect(Collectors.toList());
	}
}
