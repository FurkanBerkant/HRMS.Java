package com.kodlamaio.hrms.entities.concretes;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_seekers")
public class JobSeeker extends User{
	
	@NotBlank(message = "firstName cannot be blank")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "lastName cannot be blank")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message = "identityNumber cannot be blank")
	@Size(min = 11,max = 11,message = "11 karakter girmek zorundasiniz")
	@Column(name="identity_number",unique = true)
	private String identityNumber;
	
	@NotBlank(message = "date cannot be blank")
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	

}
