package com.kodlamaio.hrms.entities.Dtos;
import java.time.LocalDate;

import com.kodlamaio.hrms.entities.concretes.JobTitle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobExperienceDto {

	private int resumeId;
	private String companyName;
	private LocalDate startedDate;
	private LocalDate endedDate;
	private int jobTitleId;
}
