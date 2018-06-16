package com.team11.cab;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team11.cab.model.Facility;
import com.team11.cab.model.FacilityType;
import com.team11.cab.service.FacilityService;
import com.team11.cab.service.FacilityTypeService;

//import edu.iss.cats.model.Employee;

@Controller

public class FacilityController {

	@Autowired
	private FacilityService facilityService;

	@Autowired
	private FacilityTypeService facilityTypeService;

	@RequestMapping(value = "/facilities", method = RequestMethod.GET)
	public ModelAndView facilityListPage() {
		ModelAndView mav = new ModelAndView("facility-list");
		List<Facility> AvailblefacilityList = (ArrayList<Facility>)facilityService.findAvailableFacility();
		List<FacilityType> typeList= (ArrayList<FacilityType>) facilityTypeService.findAllFacilityTypes();
		
		mav.addObject("typeList",typeList);
		
		mav.addObject("facilityList", AvailblefacilityList);
		
		return mav;
	}

	@RequestMapping(value = "/admin/facilities/create", method = RequestMethod.GET)
	public ModelAndView newFacilityPage() {
		ModelAndView mav = new ModelAndView("facility-new", "facility", new Facility());
		List<FacilityType> facTypeList = facilityTypeService.findAllFacilityTypes();
		mav.addObject("facTypeList", facTypeList);
		return mav;
	}

	@RequestMapping(value = "/admin/facilities/create", method = RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("facility-new");

		ModelAndView mav = new ModelAndView();
		String message = "New facility " + facility.getFacilityId() + " was successfully created.";

		facilityService.createFacility(facility);
		mav.setViewName("redirect:/facility/admin/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/admin/facilities", method = RequestMethod.GET)
	public String facilityList() {

		return "admin-facility-list";
	}

	@RequestMapping(value = "/admin/facilities/update", method = RequestMethod.POST)
	public @ResponseBody String facilityUpdate(@RequestBody Facility f, HttpServletRequest request) {

		System.out.println(f.getFacilityName());
		facilityService.updateFacility(f);

		return "admin-facility-list";

	}

}
