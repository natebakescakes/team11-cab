package com.team11.cab.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.team11.cab.model.FacilityType;

public interface FacilityTypeRepository extends JpaRepository<FacilityType, Integer> {

//	public FacilityType findByName(String name);
	
}
