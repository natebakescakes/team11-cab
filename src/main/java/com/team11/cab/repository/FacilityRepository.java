package com.team11.cab.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
<<<<<<< HEAD
import org.springframework.data.repository.query.Param;

import com.team11.cab.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	@Query("SELECT f FROM Facility where f.facilityId= :facilityTypeId")
	ArrayList<Facility> findFacilityByFacilityType(int facilityTypeId);
	
	@Query("SELECT f FROM Facility f where f.facilityId = :id")
	Facility findFacilityById(@Param("id") Integer id);
=======

import com.team11.cab.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	@Query(value = "SELECT * FROM Facility WHERE FacilityType = ?1", nativeQuery = true)
	ArrayList<Facility> findFacilityByFacilityType(int facilityTypeId);

	@Query(value = "SELECT f FROM Facility f WHERE f.status= 1")
	ArrayList<Facility> findAvailableFacility();
>>>>>>> refs/remotes/origin/master
}
