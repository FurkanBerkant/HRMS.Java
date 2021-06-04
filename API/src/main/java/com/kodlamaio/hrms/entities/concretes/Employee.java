package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity

@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee extends User {
	@NotBlank(message = "cannot be blank")
	@Column(name = "firstname")
	private String firstName;

	@NotBlank(message = "cannot be blank")
	@Column(name = "lastname")
	private String lastName;
}