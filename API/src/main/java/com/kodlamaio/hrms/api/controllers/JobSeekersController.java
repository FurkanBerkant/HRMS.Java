package com.kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.hrms.business.abstracts.JobSeekerService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
	@Autowired
	private JobSeekerService jobSeekerService;

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return this.jobSeekerService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
		return ResponseEntity.ok(jobSeekerService.add(jobSeeker));
	}

}
