package com.kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.hrms.business.abstracts.JobPostingService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.Dtos.JobPostingGetDto;
import com.kodlamaio.hrms.entities.Dtos.JobPostingPostDto;

@RestController
@RequestMapping("/api/JobAdvertisement/")
public class JobPostingsController {
	@Autowired
	private JobPostingService jobAdvertisementService;

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPostingPostDto jobAdvertisementRequestDto) {
		return ResponseEntity.ok(jobAdvertisementService.add(jobAdvertisementRequestDto));
	}

	@GetMapping("getall")
	public DataResult<List<JobPostingGetDto>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("orderByDateDesc")
	public DataResult<List<JobPostingGetDto>> findAllByActiveTrueOrderByCreatedDateDesc() {
		return this.jobAdvertisementService.findAllByActiveTrueOrderByCreatedDateDesc();
	}

	@GetMapping("getByEmployer")
	public DataResult<List<JobPostingGetDto>> findAllByIdAndActiveTrue(@RequestParam("id") int employerId) {
		return this.jobAdvertisementService.findAllByIdAndActiveTrue(employerId);
	}

	@PutMapping("updateAdvertisement")
	public DataResult<JobPostingGetDto> update(@RequestParam("id") int id, @RequestParam("active") boolean active) {
		return this.jobAdvertisementService.update(id, active);
	}

}
