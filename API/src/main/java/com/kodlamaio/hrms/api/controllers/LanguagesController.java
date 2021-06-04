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
import com.kodlamaio.hrms.business.abstracts.LanguageService;
import com.kodlamaio.hrms.core.utilities.results.DataResult;
import com.kodlamaio.hrms.entities.Dtos.LanguageDto;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	@Autowired
	private LanguageService languageService;
	@GetMapping("/getall")
	public DataResult<List<LanguageDto>> getAll() {
		return this.languageService.getAll();
	}
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody LanguageDto languageDto) {
		return ResponseEntity.ok(languageService.add(languageDto));
	}
}
