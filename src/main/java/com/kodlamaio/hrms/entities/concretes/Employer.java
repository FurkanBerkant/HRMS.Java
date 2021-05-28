package com.kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
public class Employer extends User{
	
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "web_site_name")
	private String webSiteName;
	@Column(name = "phone")
	private String phone;
	

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement>jobAdvertisements;
    
	
	
	

}
