package com.team11.cab.service;

import java.util.ArrayList;

import com.team11.cab.model.FacilityType;

public interface FacilityTypeService {
	
	public ArrayList<FacilityType> findAllFacilityTypes();
	
	public FacilityType findByTypeId(int typeId);

}
