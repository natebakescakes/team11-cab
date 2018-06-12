package com.team11.cab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team11.cab.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> 
{
}
