package com.team11.cab.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team11.cab.model.Facility;
import com.team11.cab.repository.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Resource
	private FacilityRepository facilityRepository;

	@Override
	public ArrayList<Facility> findAllFacilities() {
		ArrayList<Facility> l = (ArrayList<Facility>) facilityRepository.findAll();
		return l;

	}

	@Override
	@Transactional
	public Facility createFacility(Facility fac) {
		return facilityRepository.saveAndFlush(fac);
	}

	@Override
	@Transactional
	public Facility findFacility(int facId) {
		return facilityRepository.findOne(facId);
	}

	@Override
	@Transactional
	public Facility editFacility(Facility fac) {
		return facilityRepository.saveAndFlush(fac);
	}

	@Override
	public void deleteFacility(Facility fac) {
		facilityRepository.delete(fac);

	}

	@Override
	public ArrayList<Facility> findFacilitiesByFacilityType(int facilityTypeId) {
		ArrayList<Facility> f = facilityRepository.findFacilityByFacilityType(facilityTypeId);
		return f;
	}

	@Override
	public Facility findFacilityById(int facilityId) {
		Facility f = facilityRepository.findOne(facilityId);
		return f;
	}
	
	@Override
	public ArrayList<Facility> findAvaibleFacility() {
		ArrayList<Facility> f= facilityRepository.findAvaibleFacility();
		return f;
	}
}
