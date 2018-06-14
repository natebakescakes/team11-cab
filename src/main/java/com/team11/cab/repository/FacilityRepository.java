package com.team11.cab.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team11.cab.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	@Query(value = "SELECT * FROM Facility WHERE FacilityType = ?1", nativeQuery = true)
	ArrayList<Facility> findFacilityByFacilityType(int facilityTypeId);

	@Query(value = "SELECT f FROM Facility f WHERE f.status= 1")
	ArrayList<Facility> findAvailableFacility();
}
