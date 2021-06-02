package com.kodlamaio.hrms.entities.Dtos;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyDto {

	private int resumeId;
	@NotBlank(message = "description cannot be blank")
	private String description;
}
