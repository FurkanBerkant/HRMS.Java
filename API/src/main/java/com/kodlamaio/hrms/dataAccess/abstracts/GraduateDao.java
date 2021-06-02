package com.kodlamaio.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.hrms.entities.concretes.Graduate;

public interface GraduateDao extends JpaRepository<Graduate, Integer>{

	boolean existsByDescription(String description);

}
