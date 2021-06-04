package com.kodlamaio.hrms.entities.Dtos;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.kodlamaio.hrms.entities.concretes.Education;
import com.kodlamaio.hrms.entities.concretes.JobExperience;
import com.kodlamaio.hrms.entities.concretes.Language;
import com.kodlamaio.hrms.entities.concretes.Technology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeGetDto {
	private int id;
	private int jobSeekerId;
	private String linkedInLink;
	private String githubLink;
	private String photoUrl;
	private String description;
	private JobExperience jobExperience;
	private Language language;
	private Technology technologies;
	private Education education;
	

}
