package com.kodlamaio.hrms.entities.Dtos;
import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kodlamaio.hrms.entities.concretes.Graduate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {

	@JsonIgnore
	private int id;
	private int resumeId;
	private String schoolName;
	private String schoolDepartment;
	private int startedDate;
	private int endedDate;
	private int graduateId;
}
