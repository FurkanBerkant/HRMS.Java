package com.kodlamaio.hrms.entities.Dtos;

import java.sql.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingDto {
	private String cityName;
	private String jobTitlePosition;
	private LocalDate createdDate;
	private String employerCompanyName;
	private String jobDescription;
	private Date applicationDeadline;
	private int vacantPosition;
	private int minimumSalary;
	private int maximumSalary;
	private boolean active;
}
