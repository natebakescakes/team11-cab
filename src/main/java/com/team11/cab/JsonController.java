package com.team11.cab;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team11.cab.model.Facility;
import com.team11.cab.model.Member;
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
		return fService.findAvailableFacility();
	}

}
