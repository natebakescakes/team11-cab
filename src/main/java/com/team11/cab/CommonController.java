package com.team11.cab;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/home")
public class CommonController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String searchBooking(@RequestParam String booking_id, ModelMap model) {
		//declare booking service
	    //validate booking exists
		//else throw error and redirect user back to homepage
		model.put("booking_id", booking_id);
		return "booking-details";
	}
}
