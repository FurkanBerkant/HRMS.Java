package com.kodlamaio.hrms.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kodlamaio.hrms.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer>{

}
