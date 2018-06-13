package com.team11.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team11.cab.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String>{
	
}
