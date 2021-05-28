package com.kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.JobSeeker;


public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>{
	boolean existsByEmail(String email);
	boolean existsByIdentityNumber(String identityNumber);
}
