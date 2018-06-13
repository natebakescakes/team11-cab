package com.team11.cab.service;

import java.util.ArrayList;

import com.team11.cab.model.Facility;

public interface FacilityService {
	ArrayList<Facility> findAllFacilities();

	Facility createFacility(Facility fac);

	Facility editFacility(Facility fac);

	Facility findFacility(int id);

	void deleteFacility(Facility fac);

	Facility findFacilityById(int facilityId);

	ArrayList<Facility> findFacilitiesByFacilityType(int facilityTypeId);
}
