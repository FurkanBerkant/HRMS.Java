package com.kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.hrms.business.abstracts.EducationService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.Dtos.EducationDto;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
	@Autowired
	private EducationService educationService;

	@GetMapping("/getall")
	public DataResult<List<EducationDto>> getAll() {
		return this.educationService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody EducationDto educationDto) {
		return ResponseEntity.ok(educationService.add(educationDto));
	}

	@GetMapping("/orderByStartedDateDesc")
	public DataResult<List<EducationDto>> orderByStartedDateDesc(int id) {
		return this.educationService.findAllByResumeIdOrderByStartedDateDesc(id);
	}
}
