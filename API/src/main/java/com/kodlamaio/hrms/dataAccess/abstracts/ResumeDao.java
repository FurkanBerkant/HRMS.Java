package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

	List<Resume> findAllByJobSeekerId(int jobSeekerId);
}
