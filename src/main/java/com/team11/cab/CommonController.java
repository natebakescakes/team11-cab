package com.team11.cab;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team11.cab.service.FacilityService;

@Controller
@RequestMapping(value = "/home")
public class CommonController {

	@Autowired
	private FacilityService fService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() {
		
		return "home";
		
	
		
		
	}
	


}
