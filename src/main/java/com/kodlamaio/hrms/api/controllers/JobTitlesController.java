package com.kodlamaio.hrms.api.controllers;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobTitleService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/position")
public class JobTitlesController {
	private JobTitleService jobPositionService;

	@Autowired
	public JobTitlesController(JobTitleService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobTitle jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}
	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll() {
		return this.jobPositionService.getAll();
	}
}