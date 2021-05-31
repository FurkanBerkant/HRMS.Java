package com.kodlamaio.hrms.api.controllers;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.kodlamaio.hrms.business.abstracts.ActivationCodeService;
import com.kodlamaio.hrms.core.utilities.results.ErrorDataResult;
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
