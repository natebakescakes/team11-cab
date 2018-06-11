package com.team11.cab.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team11.cab.model.Employee;
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
	@Transactional
	public Facility createFacility(Facility fac) {
		return facilityrepository.saveAndFlush(fac);
	}

	@Override
	@Transactional
	public Facility findFacility(int facId) {
		return facilityrepository.findOne(facId);
	}

	@Override
	@Transactional
	public Facility editFacility(Facility fac) {
		return facilityrepository.saveAndFlush(fac);
	}

	@Override
	public void deleteFacility(Facility fac) {
		facilityrepository.delete(fac);

	}
}
