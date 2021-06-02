package com.kodlamaio.hrms.entities.Dtos;

import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDto {
	@NotBlank(message = "jobSeekerId cannot be blank")
	private int jobSeekerId;
	private String schoolName;
	private String schoolPart;
	private LocalDate schoolBeginingYear;
	private LocalDate schoolGraduateYear;
	
	private JobExperienceDto jobExperience;
	private LanguageDto language;
	private TechnologyDto technologies;
	private EducationDto education;
	private String jobPosition;
	

}
