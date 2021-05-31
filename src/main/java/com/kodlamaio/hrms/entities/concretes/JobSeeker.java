package com.kodlamaio.hrms.entities.concretes;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.kodlamaio.hrms.core.entities.User;
import com.sun.istack.NotNull;

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
	
	@NotBlank
	@NotNull
	@Column(name="firstname")
	private String firstName;
	@NotBlank
	@NotNull
	@Column(name="lastname")
	private String lastName;
	@NotBlank
	@NotNull
	@Size(min = 11,max = 11,message = "11 karakter girmek zorundasiniz")
	@Column(name="identity_number",unique = true)
	private String identityNumber;
	@Column(name="date_of_birth")
	private Date date;
	

}
