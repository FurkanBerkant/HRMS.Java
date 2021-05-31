package com.kodlamaio.hrms.dataAccess.abstracts;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	List<JobPosting> findAllByActiveTrue();
    List<JobPosting> findAllByEmployerIdAndActiveTrue(int employerId);
    List<JobPosting> findAllByActiveTrueOrderByCreatedDateDesc();
}
