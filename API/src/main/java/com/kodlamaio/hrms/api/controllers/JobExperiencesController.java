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
import com.kodlamaio.hrms.business.abstracts.JobExperienceService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.Dtos.JobExperienceDto;
import com.kodlamaio.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobexperiences")
public class JobExperiencesController {

	@Autowired
	private JobExperienceService jobExperienceService;
	
	@GetMapping("/getall")
	public DataResult<List<JobExperience>> getAll() {
		return this.jobExperienceService.getAll();
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobExperienceDto jobExperienceDto) {
		return  ResponseEntity.ok(jobExperienceService.add(jobExperienceDto));
	}
}
