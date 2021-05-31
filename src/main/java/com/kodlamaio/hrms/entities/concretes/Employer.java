package com.kodlamaio.hrms.entities.concretes;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kodlamaio.hrms.core.entities.User;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisements"})
public class Employer extends User{
	
	@NotBlank
	@NotNull
	@Column(name = "company_name")
	private String companyName;
	@NotBlank
	@NotNull
	@Column(name = "web_site_name")
	private String webSiteName;
	@NotBlank
	@NotNull
	@Column(name = "phone")
	private String phone;
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobPosting> jobAdvertisements;

	
	
	

}
