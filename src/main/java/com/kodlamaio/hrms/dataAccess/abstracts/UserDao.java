package com.kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.hrms.core.entities.User;

public interface UserDao extends JpaRepository<User,Integer> {
	boolean existsByEmail(String email);
}
