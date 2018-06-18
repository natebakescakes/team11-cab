package com.team11.cab.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team11.cab.model.FacilityType;
import com.team11.cab.repository.FacilityTypeRepository;

@Service
public class FacilityTypeServiceImpl implements FacilityTypeService {

	@Resource
	private FacilityTypeRepository facilityTypeRepository;
	
	@Override
	@Transactional
	public ArrayList<FacilityType> findAllFacilityTypes() {
		ArrayList<FacilityType> ft = (ArrayList<FacilityType>) facilityTypeRepository.findAll();
		return ft;
	}
	
	public FacilityType findByTypeId(int typeId) {
		return facilityTypeRepository.findOne(typeId);
	}

	@Override
	public FacilityType updateFacilityType(FacilityType facilityType) {
		return facilityTypeRepository.saveAndFlush(facilityType);
	}

}
