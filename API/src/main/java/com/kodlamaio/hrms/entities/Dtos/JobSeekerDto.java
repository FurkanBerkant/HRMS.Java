package com.kodlamaio.hrms.entities.Dtos;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerDto {

	@NotBlank(message = "firstName cannot be blank")
	private String firstName;
	
	@NotBlank(message = "lastName cannot be blank")
	private String lastName;
	
	@NotBlank(message = "identityNumber cannot be blank")
	@Size(min = 11, max = 11, message = "11 karakter girmek zorundasiniz")
	private String identityNumber;
	
	@NotBlank(message = "date cannot be blank")
	private LocalDate dateOfBirth;
	
	private String email;
	private String password;
	private String passwordCheck;
}
