package com.kodlamaio.hrms.entities.Dtos;

import java.time.LocalDate;
import javax.validation.constraints.Min;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDto {

	@JsonIgnore
	private int id;
	private int resumeId;
	private String schoolName;
	private String schoolDepartment;
	@Min(value = 1900)
	private LocalDate startedDate;
	private LocalDate endedDate;
	private int graduateId;
}
