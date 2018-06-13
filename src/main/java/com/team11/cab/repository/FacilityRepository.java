package com.team11.cab.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team11.cab.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	ArrayList<Facility> findFacilityByFacilityType(int facilityTypeId);
	
//	@Query("SELECT f FROM Facility f where f.facilityId = :id")
//	Facility findFacilityById(@Param("id") Integer id);
}
