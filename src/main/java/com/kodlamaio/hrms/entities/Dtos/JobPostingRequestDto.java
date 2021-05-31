package com.kodlamaio.hrms.entities.Dtos;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingRequestDto {
	private int cityId;
	private int employerId;
	private int jobTitleId;
	private int id;
	@NotBlank
	@NotNull
	private String jobDescription;
	private Date applicationDeadline;
	@NotBlank
	@NotNull
	private int vacantPosition;
	private int minimumSalary;
	private int maximumSalary;
	private boolean active;

}
