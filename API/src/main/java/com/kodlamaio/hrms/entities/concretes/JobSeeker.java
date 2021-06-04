package com.kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "job_seekers")
@JsonIgnoreProperties({ "hibernateLazyInitilazier", "handler", "resume" })
public class JobSeeker extends User {

	@NotBlank(message = "firstname cannot not blank")
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message = "lastName cannot not blank")
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message = "id cannot not blank")
	@Column(name = "identity_number", unique = true)
	@Size(min = 11,max = 11,message = "Must be 11 characters")
	private String identityNumber;
	
	
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Resume> resume;
}
