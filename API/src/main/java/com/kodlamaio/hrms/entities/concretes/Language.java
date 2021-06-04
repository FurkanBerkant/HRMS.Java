package com.kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "resume_langs")
public class Language {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "resume_id")
	private Resume resume;

	@Column(name = "language")
	private String language;

	@JsonIgnore
	@Column(name = "created_date")
	private LocalDate createdDate = LocalDate.now();

	@Column(name = "language_level")
	private short langLevel;

}
