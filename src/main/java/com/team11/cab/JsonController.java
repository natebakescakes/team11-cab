package com.team11.cab;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

<<<<<<< HEAD
=======
import com.team11.cab.model.Booking;
>>>>>>> refs/remotes/origin/master
import com.team11.cab.model.Facility;
import com.team11.cab.model.Member;
<<<<<<< HEAD
=======
import com.team11.cab.service.BookingService;
>>>>>>> refs/remotes/origin/master
import com.team11.cab.service.FacilityService;
//import com.team11.cab.service.FacilityTypeService;
import com.team11.cab.service.MemberService;


@Controller
@RequestMapping(value = "/json")
public class JsonController {

	@Autowired
	private MemberService mService;
	@Autowired
	private FacilityService fService;
//	@Autowired
//	private FacilityTypeService ftService;
<<<<<<< HEAD
=======
	@Autowired
	private BookingService bService;
>>>>>>> refs/remotes/origin/master
	
<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/master
	@RequestMapping(value = "/showmember")
	@ResponseBody
	public ArrayList<Member> jsonMembers() 
	{
		return mService.findAllMember();
	}
	@RequestMapping(value = "/showfacility")
	@ResponseBody
	public ArrayList<Facility> jsonFacilities() 
	{
//		ArrayList<Facility> facList = fService.findAllFacilities();
//		for (Facility facility : facList) {
//			System.out.println(facility.getFacilityType().getTypeName());
//		}

//		ArrayList<Facility> facList = fService.findAllFacilities();
//		ArrayList<FacilityType> facTypeList = ftService.findAllFacilityTypes();
//		for (Facility facility : facList) {
//			for (FacilityType facilityType : facTypeList) {
//				if (facility.getFacilityType().getTypeId()==facilityType.getTypeId()) {
//					facility.setFacTypeId(facilityType.getTypeId());
//					break;
//				}
//			}	
//		}
		
//		return facList;
		return fService.findAllFacilities();
	}
<<<<<<< HEAD
=======

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
>>>>>>> refs/remotes/origin/master

}
