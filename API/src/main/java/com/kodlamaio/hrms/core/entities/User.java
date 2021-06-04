package com.kodlamaio.hrms.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import com.sun.istack.NotNull;

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
	@NotBlank
	@NotNull
	@Column(name = "email", unique = true)
	private String email;

	@NotBlank
	@NotNull
	@Column(name = "password")
	private String password;

	@NotBlank
	@NotNull
	@Transient
	private String passwordCheck;

}
