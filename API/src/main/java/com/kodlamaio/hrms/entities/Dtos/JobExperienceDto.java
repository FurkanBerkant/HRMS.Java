package com.kodlamaio.hrms.entities.Dtos;

import java.time.LocalDate;

import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceDto {
	@JsonIgnore
	private int id;
	private int resumeId;
	private String companyName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "start date cannot be future time")
	private LocalDate startedDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endedDate;
	private int jobTitleId;
}
