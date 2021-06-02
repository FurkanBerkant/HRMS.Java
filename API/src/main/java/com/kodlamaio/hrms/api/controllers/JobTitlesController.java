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
import com.kodlamaio.hrms.business.abstracts.JobTitleService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/position")
public class JobTitlesController {
	@Autowired
	private JobTitleService jobPositionService;
	
	@GetMapping("/getall")
	public DataResult<List<JobTitle>> getAll() {
		return this.jobPositionService.getAll();
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobTitle jobPosition) {
		return  ResponseEntity.ok(jobPositionService.add(jobPosition));
	}
	
}