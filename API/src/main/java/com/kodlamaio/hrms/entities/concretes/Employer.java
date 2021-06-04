package com.kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobAdvertisements" })
public class Employer extends User {

	@NotBlank
	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "cannot be blank")
	@Column(name = "web_site_name")
	private String webSiteName;

	@NotBlank(message = "cannot be blank")
	@Column(name = "phone")
	private String phone;

}
