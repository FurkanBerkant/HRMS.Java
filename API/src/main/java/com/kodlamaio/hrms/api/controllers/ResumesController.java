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
import org.springframework.web.multipart.MultipartFile;
import com.kodlamaio.hrms.business.abstracts.ResumeService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.Result;
import com.kodlamaio.hrms.entities.Dtos.ResumeGetDto;
import com.kodlamaio.hrms.entities.Dtos.ResumePostDto;
import com.kodlamaio.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
public class ResumesController {
	@Autowired
	private ResumeService resumeService;

	@GetMapping("/getall")
	public DataResult<List<ResumeGetDto>> getAll() {
		return this.resumeService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody ResumePostDto resumeRequestDto) {
		return ResponseEntity.ok(resumeService.add(resumeRequestDto));
	}

	@GetMapping("getByJobSeekerId")
	public DataResult<List<Resume>> findAllById(@RequestParam("id") int jobSeekerId) {
		return this.resumeService.findAllJobSeekerById(jobSeekerId);
	}

	@PutMapping("/uploadImage")
	public Result saveImage(@RequestBody MultipartFile file, @RequestParam int resumeId) {
		return this.resumeService.saveImage(file, resumeId);

	}
}
