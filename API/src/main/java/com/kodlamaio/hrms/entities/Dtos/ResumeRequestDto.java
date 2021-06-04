package com.kodlamaio.hrms.entities.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeRequestDto {
	@JsonIgnore
	private int id;
	private int jobSeekerId;
	private String linkedInLink;
	private String githubLink;
	private String photoUrl;
	private String description;

}
