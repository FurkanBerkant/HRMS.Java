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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "job_advertisement")
public class JobPosting {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobTitle jobTitle;

	@ManyToOne()
	@JoinColumn(name = "company_name_id")
	private Employer employer;

	@Column(name = "vacant_position")
	private int vacantPosition;

	@Column(name = "minimum_salary")
	private int minimumSalary;

	@Column(name = "maximum_salary")
	private int maximumSalary;

	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();

	@Column(name = "active")
	private boolean active=true;

}
