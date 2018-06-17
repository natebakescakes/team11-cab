package com.team11.cab;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		List<Facility> AvailblefacilityList = (ArrayList<Facility>) facilityService.findAvailableFacility();
		List<FacilityType> typeList = (ArrayList<FacilityType>) facilityTypeService.findAllFacilityTypes();

		mav.addObject("typeList", typeList);

		mav.addObject("facilityList", AvailblefacilityList);

		return mav;
	}

	@RequestMapping(value = "/admin/facilities/create", method = RequestMethod.GET)
	public ModelAndView newFacilityPage() {
		ModelAndView mav = new ModelAndView("facility-new");
		Facility facility = new Facility();
		mav.addObject("facility", facility);

		List<FacilityType> facTypeList = facilityTypeService.findAllFacilityTypes();
		mav.addObject("facTypeList", facTypeList);
		return mav;
	}

	@RequestMapping(value = "/admin/facilities/create", method = RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView();

		for (Object object : result.getAllErrors()) {
			if (object instanceof FieldError) {
				FieldError fieldError = (FieldError) object;

				System.out.println(fieldError.getCode());
			}
		}

		if (result.hasErrors()) {
			mav.setViewName("redirect:/admin/facilities/create");
			return mav;
		}

		String message = "Facility was successfully created.";

		facility.setStatus(1);
		facility.setFacilityType(facilityTypeService.findByTypeId(facility.getFacilityType().getTypeId()));
		facilityService.createFacility(facility);
		mav.setViewName("redirect:/admin/facilities");

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
