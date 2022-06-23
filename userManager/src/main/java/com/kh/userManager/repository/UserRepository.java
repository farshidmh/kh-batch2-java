package com.kh.UserManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.UserManager.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByActive(boolean active);
	
	User findByName(String name);
	
	List<User> findByFamilyContaining(String family);
	
	
}
