package com.kodlamaio.hrms.entities.Dtos;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerDto {

	private String firstName;
	private String lastName;
	private String identityNumber;
	private LocalDate dateOfBirth;
	private String email;
	private String password;
	private String passwordCheck;
}
