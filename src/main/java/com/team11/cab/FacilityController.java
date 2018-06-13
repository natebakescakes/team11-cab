package com.team11.cab;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team11.cab.model.Facility;
import com.team11.cab.model.FacilityType;
import com.team11.cab.service.FacilityService;
import com.team11.cab.service.FacilityTypeService;

//import edu.iss.cats.model.Employee;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {

	@Autowired
	private FacilityService facilityService;

	@Autowired
	private FacilityTypeService facilityTypeService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView facilityListPage() {
		ModelAndView mav = new ModelAndView("facility-list");
		// List<Facility> facilityList =
		// (ArrayList<Facility>)facilityService.findAllFacilities();
		List<FacilityType> typeList = (ArrayList<FacilityType>) facilityTypeService.findAllFacilityTypes();

		mav.addObject("typeList", typeList);

		// mav.addObject("facilityList", facilityList);

		return mav;
	}

	@RequestMapping(value = "/admin/list", method = RequestMethod.GET)
	public ModelAndView facilityListAdminPage() {
		ModelAndView mav = new ModelAndView("admin-facility-list");
		List<Facility> facilityList = (ArrayList<Facility>) facilityService.findAllFacilities();
		mav.addObject("facilityList", facilityList);
		return mav;

	}

	@RequestMapping(value = "/admin/create", method = RequestMethod.GET)
	public ModelAndView newFacilityPage() {
		ModelAndView mav = new ModelAndView("facility-new", "facility", new Facility());
		List<FacilityType> facTypeList = facilityTypeService.findAllFacilityTypes();
		mav.addObject("facTypeList", facTypeList);
		return mav;
	}

	@RequestMapping(value = "/admin/create", method = RequestMethod.POST)
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

	@RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editFacilityPage(@PathVariable int id) {

		ModelAndView mav = new ModelAndView("facility-edit");
		Facility facility = facilityService.findFacility(id);
		mav.addObject("facility", facility);
		return mav;
	}

	@RequestMapping(value = "/admin/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
			@PathVariable int id, final RedirectAttributes redirectAttributes) {

		// if (result.hasErrors())
		// return new ModelAndView("facility-edit");

		ModelAndView mav = new ModelAndView("redirect:/facility/admin/list");
		String message = "Employee was successfully updated.";

		facilityService.editFacility(facility);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteFacility(@PathVariable int id, final RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("redirect:/facility/admin/list");
		Facility facility = facilityService.findFacility(id);
		facilityService.deleteFacility(facility);
		String message = "The facility " + facility.getFacilityId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

}
