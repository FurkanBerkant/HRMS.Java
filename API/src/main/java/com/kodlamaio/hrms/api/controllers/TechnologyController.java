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
import com.kodlamaio.hrms.business.abstracts.TechnologyService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.Dtos.TechnologyDto;
import com.kodlamaio.hrms.entities.concretes.Technology;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {
	@Autowired
	private TechnologyService technologyService;
	@GetMapping("/getall")
	
	public DataResult<List<Technology>> getAll() {
		return this.technologyService.getAll();
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody TechnologyDto technologyDto) {
		return  ResponseEntity.ok(technologyService.add(technologyDto));
	}
}
