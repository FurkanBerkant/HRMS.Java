package com.kodlamaio.hrms.entities.Dtos;
import java.sql.Date;
import java.time.LocalDate;

import com.kodlamaio.hrms.entities.concretes.Graduate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {

	private int resumeId;
	private String schoolName;
	private String schoolDepartment;
	private LocalDate startedDate;
	private LocalDate endedDate;
	private Graduate graduate;
}
