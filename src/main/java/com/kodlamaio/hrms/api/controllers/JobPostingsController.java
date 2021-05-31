package com.kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import com.kodlamaio.hrms.entities.Dtos.JobPostingDto;
import com.kodlamaio.hrms.entities.Dtos.JobPostingRequestDto;

@RestController
@RequestMapping("/api/JobAdvertisement/")
public class JobPostingsController {
	@Autowired
	private JobAdvertisementService jobAdvertisementService;

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPostingRequestDto jobAdvertisementRequestDto) {
		return ResponseEntity.ok(jobAdvertisementService.add(jobAdvertisementRequestDto));
	}

	@GetMapping("getall")
	public DataResult<List<JobPostingDto>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	@GetMapping("orderByDateDesc")
	public DataResult<List<JobPostingDto>> findAllByActiveTrueOrderByCreatedDateDesc(){
		return this.jobAdvertisementService.findAllByActiveTrueOrderByCreatedDateDesc();
	}
	@GetMapping("getByEmployer")
	public DataResult<List<JobPostingDto>> findAllByIdAndActiveTrue(@RequestParam("id") int employerId){
		return this.jobAdvertisementService.findAllByIdAndActiveTrue(employerId);
	}
	@PutMapping("updateAdvertisement")
	public DataResult<JobPostingDto> update(@RequestParam("id") int id,
												  @RequestParam("active") boolean active)
	{
		return this.jobAdvertisementService.update(id, active);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError :exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors= new ErrorDataResult<Object>
															(validationErrors,"Dogrulama hatalari");
		return errors;
		}
	
}
