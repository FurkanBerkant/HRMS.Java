package com.kodlamaio.hrms.entities.Dtos;

import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyDto {
	@JsonIgnore
	private int id;
	private int resumeId;
	@NotBlank(message = "description cannot notblank")
	private String description;
}
