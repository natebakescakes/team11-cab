package com.team11.cab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team11.cab.model.Facility;
import com.team11.cab.service.FacilityService;

@Controller
@RequestMapping(value="/facility")
public class FacilityController {
	
	@Autowired
	private FacilityService facilityService;
	
	@RequestMapping(value = "/facilitylist", method = RequestMethod.GET)
	public ModelAndView facilityListPage() {
		ModelAndView mav = new ModelAndView("facility-list");
		List<Facility> facilityList = (ArrayList<Facility>)facilityService.findAllFacilities();
		mav.addObject("facilityList", facilityList);
		return mav;
	}

}
