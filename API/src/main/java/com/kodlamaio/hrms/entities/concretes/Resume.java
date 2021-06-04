package com.kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
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
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice.Local;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resumes")
@JsonIgnoreProperties({ "hibernateLazyInitilazier", "handler" })
public class Resume {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();

	@Column(name = "is_active")
	private boolean active;

	@Column(name = "photo_url")
	private String photoUrl;

	@Column(name = "linkedın_link")
	private String linkedInLink;

	@Column(name = "github_link")
	private String githubLink;
	
	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDate updatedDate;
	
	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;

	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "resume")
	private List<Language> languages;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "resume")
	private List<Technology> technologies;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "resume")
	private List<Education> education;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "resume")
	private List<JobExperience> jobExperiences;
	
	
	
}
