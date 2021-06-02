package com.kodlamaio.hrms.api.controllers;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.hrms.business.abstracts.ActivationCodeService;
import com.kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/activation")
public class ActivationCodesController {
	@Autowired
	private ActivationCodeService activationCodeService;
	


	@PostMapping("/verify/{activationCode}")
	public ResponseEntity<?> verify(@Valid @RequestParam("activationCode") String code) {
		Result result = activationCodeService.verify(code);
		
		return ResponseEntity.ok(result);
	}
}
