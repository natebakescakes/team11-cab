<<<<<<< HEAD
package com.team11.cab.service;

import java.util.List;

import com.team11.cab.model.Facility;

public interface FacilityService {
	List<Facility> findAllFacilities();

	Facility createFacility(Facility fac);

    Facility editFacility(Facility fac);

	Facility findFacility(int id);

    void deleteFacility(Facility fac);

}
=======
package com.team11.cab.service;

import java.util.List;

import com.team11.cab.model.Facility;

public interface FacilityService {
	List<Facility> findAllFacilities();
	
}
>>>>>>> refs/heads/master
