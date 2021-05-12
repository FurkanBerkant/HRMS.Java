package com.kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobService;
import com.kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/position")
public class JobController {
	private JobService jobService;

	@Autowired
	public JobController(JobService jobService) {
		this.jobService = jobService;
	}

	@GetMapping("/getall")
	public List<JobPosition> getAll() {
		return this.jobService.getAll();
	}

}