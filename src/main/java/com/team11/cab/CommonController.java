package com.team11.cab;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team11.cab.model.FacilityType;
import com.team11.cab.service.FacilityService;
import com.team11.cab.service.FacilityTypeService;

@Controller
@RequestMapping(value = "/home")
public class CommonController {

	@Autowired
	private FacilityTypeService ftService;
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		
	List<FacilityType> facilityTypeList = ftService.findAllFacilityTypes();
		
	model.addAttribute("fTypeList", facilityTypeList);

	return "home";		
		
	}

}
