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
public class JobPostingRequestDto {
	private int cityId;
	private int employerId;
	private int jobTitleId;
	private int id;
	@NotBlank
	private String jobDescription;
	private LocalDate applicationDeadline;
	@NotBlank
	private int vacantPosition;
	private int minimumSalary;
	private int maximumSalary;
	private boolean active;

}
