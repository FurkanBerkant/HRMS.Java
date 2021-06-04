package com.kodlamaio.hrms.entities.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
	private String cityName;
	private int plateCode;
}
