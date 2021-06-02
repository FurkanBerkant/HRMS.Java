package com.kodlamaio.hrms.entities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto {

	private int resumeId;
	private String language;
	private int languageLevel;
}
