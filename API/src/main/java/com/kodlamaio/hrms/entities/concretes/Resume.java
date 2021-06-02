package com.kodlamaio.hrms.entities.concretes;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resumes")
@JsonIgnoreProperties({"hibernateLazyInitilazier","handler"})
public class Resume{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_date")
	private LocalDate createdDate=LocalDate.now();
	
	@Column(name = "is_active")
	private boolean active;
	
	@Column(name = "photo")
	private String photo;
	
	@Column(name = "linkedın_link")
	private String linkedInLink;
	
	@Column(name = "github_link")
	private String githubLink;
	
	
	@ManyToOne(targetEntity = JobSeeker.class)
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "resume")
	private List<Technology> technologies;
	
	@OneToMany(mappedBy = "resume")
	private List<Education> education;
	
	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;
}
