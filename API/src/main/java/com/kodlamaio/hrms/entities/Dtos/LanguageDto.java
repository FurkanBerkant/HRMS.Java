package com.kodlamaio.hrms.entities.Dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto {
	@JsonIgnore
	private int id;
	private int resumeId;
	@NotBlank(message = "language cannot be blank")
	private String language;
	@Min(value = 1,message = "min 1")
	@Max(value = 5,message = "max 5")
	private short langLevel;
	
}
