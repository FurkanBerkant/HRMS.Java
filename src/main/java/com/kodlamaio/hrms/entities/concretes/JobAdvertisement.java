package com.kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "job_advertisement")
public class JobAdvertisement {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="job_description")
	private String jobDescription;
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	@Column(name = "vacant_position")
	private int vacantPosition;
	
	@Column(name = "minimum_salary")
	private int minimumSalary;
	
	@Column(name = "maximum_salary")
	private int maximumSalary;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "active")
	private boolean active;
	
}
	