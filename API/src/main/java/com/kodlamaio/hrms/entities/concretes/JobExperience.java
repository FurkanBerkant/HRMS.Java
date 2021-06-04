package com.kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resume_job_exp")
public class JobExperience {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotBlank(message = "companyName cannot be blank")
	@Column(name = "company_name")
	private String companyName;

	@ManyToOne(targetEntity = JobTitle.class)
	@JoinColumn(name = "job_position_id")
	private JobTitle jobTitle;

	@Column(name = "started_date")
	private LocalDate startedDate;

	@Column(name = "ended_date")
	private LocalDate endedDate;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name = "resume_id")
	private Resume resume;

	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();

}
