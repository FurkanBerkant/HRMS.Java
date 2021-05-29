package com.kodlamaio.hrms.dataAccess.abstracts;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	List<JobAdvertisement> findAllByActiveTrue();
    List<JobAdvertisement> findAllByEmployerIdAndActiveTrue(int employerId);
    List<JobAdvertisement> findAllByActiveTrueOrderByCreatedDateDesc();
}
