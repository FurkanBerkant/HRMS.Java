package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.Dtos.JobAdvertisementDto;
import com.kodlamaio.hrms.entities.Dtos.JobAdvertisementRequestDto;

@RestController
@RequestMapping("/api/JobAdvertisement/")
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	@PostMapping("add")
	public Result add(@RequestBody JobAdvertisementRequestDto jobAdvertisementRequestDto) {
		return this.jobAdvertisementService.add(jobAdvertisementRequestDto);
	}

	@GetMapping("getall")
	public DataResult<List<JobAdvertisementDto>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	@GetMapping("orderByDateDesc")
	public DataResult<List<JobAdvertisementDto>> findAllByActiveTrueOrderByCreatedDateDesc(){
		return this.jobAdvertisementService.findAllByActiveTrueOrderByCreatedDateDesc();
	}
	@GetMapping("getByEmployer")
	public DataResult<List<JobAdvertisementDto>> findAllByIdAndActiveTrue(@RequestParam("id") int employerId){
		return this.jobAdvertisementService.findAllByIdAndActiveTrue(employerId);
	}
	@PutMapping("updateAdvertisement")
	public DataResult<JobAdvertisementDto> update(@RequestParam("id") int id,
												  @RequestParam("active") boolean active)
	{
		return this.jobAdvertisementService.update(id, active);
	}
	
}
