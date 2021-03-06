package com.team11.cab;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team11.cab.model.Booking;
import com.team11.cab.model.Facility;
import com.team11.cab.model.FacilityType;
import com.team11.cab.model.Member;
import com.team11.cab.service.BookingService;
import com.team11.cab.service.FacilityService;
import com.team11.cab.service.FacilityTypeService;
//import com.team11.cab.service.FacilityTypeService;
import com.team11.cab.service.MemberService;

@Controller
@RequestMapping(value = "/json")
public class JsonController {

	@Autowired
	private MemberService mService;
	@Autowired
	private FacilityService fService;
	@Autowired
	private FacilityTypeService ftService;
	@Autowired
	private BookingService bService;

	@RequestMapping(value = "/showmember")
	@ResponseBody
	public ArrayList<Member> jsonMembers() {
		return mService.findAllMember();
	}

	@RequestMapping(value = "/showfacility")
	@ResponseBody
	public ArrayList<Facility> jsonFacilities() {
	
		return fService.findAllFacilities();
	}

	@RequestMapping(value = "/showbooking")
	@ResponseBody
	public ArrayList<Booking> jsonBookings() {
		return bService.findAllBookings();
	}

	@RequestMapping(value = "/showmybooking")
	@ResponseBody
	public ArrayList<Booking> jsonmyBookings(Authentication authentication) {
		String username = authentication.getName();

		return bService.findMyBookings(username);
	}
	
	@RequestMapping(value = "/showfacilitytypes")
	@ResponseBody
	public ArrayList<FacilityType> jsonFacilityTypes() {
		return ftService.findAllFacilityTypes();
	}

}
