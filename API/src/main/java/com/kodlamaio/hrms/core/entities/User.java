package com.kodlamaio.hrms.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Email
	@NotBlank(message = "email cannot not blank")
	@Column(name = "email", unique = true)
	private String email;

	@NotBlank(message = "password cannot not blank")
	@Column(name = "password")
	private String password;

	@JsonIgnore
	@NotBlank(message = "passwordCheck cannot not blank")
	@Transient
	private String passwordCheck;

}
