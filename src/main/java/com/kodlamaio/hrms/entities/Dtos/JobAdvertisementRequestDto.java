package com.kodlamaio.hrms.entities.Dtos;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementRequestDto {
	private int cityId;
	private int employerId;
	private int jobTitleId;
	private int id;
	private String jobDescription;
	private Date applicationDeadline;
	private int vacantPosition;
	private int minimumSalary;
	private int maximumSalary;
	private boolean active;

}
