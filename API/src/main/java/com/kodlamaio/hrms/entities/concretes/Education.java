package com.kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resume_edu")
public class Education {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name = "resume_id")
	private Resume resume;

	@NotBlank(message = "schoolName cannot be blank")
	@Column(name = "school_name")
	private String schoolName;

	@NotBlank(message = "schoolDepartment cannot be blank")
	@Column(name = "school_department")
	private String schoolDepartment;

	@Column(name = "started_date")
	private int startedDate;

	@Column(name = "ended_date")
	private int endedDate;

	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();

	@ManyToOne(targetEntity = Graduate.class)
	@JoinColumn(name = "graduate_id")
	private Graduate graduate;
}
