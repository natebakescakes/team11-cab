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

import com.team11.cab.exception.EmployeeNotFound;
import com.team11.cab.model.Employee;
import com.team11.cab.model.Facility;
import com.team11.cab.service.FacilityService;

@Controller
@RequestMapping(value = "/facility")
public class FacilityController {

	@Autowired
	private FacilityService facilityService;

	@RequestMapping(value = "/facilitylist", method = RequestMethod.GET)
	public ModelAndView facilityListPage() {
		ModelAndView mav = new ModelAndView("facility-list");
		List<Facility> facilityList = (ArrayList<Facility>) facilityService.findAllFacilities();
		mav.addObject("facilityList", facilityList);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newFacility(Model model) {
		model.addAttribute("facility", new Facility());
		return "facility-new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		// if (result.hasErrors())
		// return new ModelAndView("facility-new");

		ModelAndView mav = new ModelAndView();
		String message = "New facility " + facility.getFacilityId() + " was successfully created.";

		facilityService.createFacility(facility);
		mav.setViewName("redirect:facilitylist");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editFacilityPage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("facility-edit");
		Facility facility = facilityService.findFacility(id);
		mav.addObject("facility", facility);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editFacility(@ModelAttribute @Valid Facility facility, BindingResult result,
			@PathVariable int id, final RedirectAttributes redirectAttributes) {

		// if (result.hasErrors())
		// return new ModelAndView("facility-edit");

		ModelAndView mav = new ModelAndView("redirect:/facility/facilitylist");
		String message = "Employee was successfully updated.";

		facilityService.editFacility(facility);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteFacility(@PathVariable int id, final RedirectAttributes redirectAttributes)
			throws EmployeeNotFound {
		ModelAndView mav = new ModelAndView("redirect:/facility/facilitylist");
		Facility facility = facilityService.findFacility(id);
		facilityService.deleteFacility(facility);
		String message = "The employee " + facility.getFacilityId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
}
