package com.kodlamaio.hrms.entities.Dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingDto {
	private String cityName;
	private String jobTitlePosition;
	private Date createdDate;
	private String employerCompanyName;
	private int id;
	private String jobDescription;
	private Date applicationDeadline;
	private int vacantPosition;
	private int minimumSalary;
	private int maximumSalary;
	private boolean active;
}

