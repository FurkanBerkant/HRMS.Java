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
import com.kodlamaio.hrms.business.abstracts.GraduateService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.concretes.Graduate;

@RestController
@RequestMapping("/api/graduates")
public class GraduatesController {

	@Autowired
	private GraduateService graduateService;

	@GetMapping("/getall")
	public DataResult<List<Graduate>> getAll() {
		return this.graduateService.getAll();
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Graduate graduate) {
		return  ResponseEntity.ok(graduateService.add(graduate));
	}
}
