package com.kodlamaio.hrms.entities.Dtos;

import java.util.List;

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
	private List<JobExperience> jobExperiences;
	private List<Language> languages;
	private List<Technology> technologies;
	private List<Education> education;

}
