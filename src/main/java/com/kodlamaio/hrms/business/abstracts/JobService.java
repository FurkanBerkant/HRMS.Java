package com.kodlamaio.hrms.business.abstracts;

import java.util.List;

import com.kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobService {
	List<JobPosition> getAll();
}