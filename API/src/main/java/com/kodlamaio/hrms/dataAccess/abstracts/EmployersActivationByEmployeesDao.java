package com.kodlamaio.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.entities.concretes.EmployersActivationByEmployees;

public interface EmployersActivationByEmployeesDao extends JpaRepository<EmployersActivationByEmployees, Integer> {

	Optional<EmployersActivationByEmployees> findByEmployerId(int id);

	boolean existsByEmployerIdAndEmployeeId(int employeeId, int employerId);
}
