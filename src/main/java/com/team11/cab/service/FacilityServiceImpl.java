package com.team11.cab.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.team11.cab.model.Facility;
import com.team11.cab.repository.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Resource
	private FacilityRepository facilityrepository;

	@Override
	public List<Facility> findAllFacilities() {
		List<Facility> l = (ArrayList<Facility>) facilityrepository.findAll();
		return l;
	}

	@Override
	public ArrayList<Facility> findFacilitiesByFacilityType(int facilityTypeId) {
		ArrayList<Facility> f = facilityrepository.findFacilityByFacilityType(facilityTypeId);
		return f;
	}

	@Override
	public Facility findFacilityById(int facilityId) {
		Facility f = facilityrepository.findOne(facilityId);
		return f;
	}

}
