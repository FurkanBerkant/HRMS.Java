package com.kodlamaio.hrms.entities.Dtos;

import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingPostDto {
	@JsonIgnore
	private int id;
	private int cityId;
	private int employerId;
	private int jobTitleId;
	@NotBlank(message = "description cannot notblank")
	private String jobDescription;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "deadline cannot be past")
	private LocalDate applicationDeadline;

	@Min(value = 1, message = "number of open positions required")
	private int vacantPosition;
	private int minimumSalary;
	private int maximumSalary;

}
