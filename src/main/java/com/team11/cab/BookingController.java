package com.team11.cab;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team11.cab.model.Booking;
import com.team11.cab.model.Facility;
import com.team11.cab.model.FacilityType;
import com.team11.cab.service.BookingService;
import com.team11.cab.service.FacilityService;
import com.team11.cab.service.FacilityTypeService;

@RequestMapping(value = "/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingService bService;
	@Autowired
	private FacilityService facilityService;
	
	@Autowired
	private FacilityTypeService typeService; 

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView bookingPostPage(HttpServletRequest request, RedirectAttributes redir) {

		ModelAndView mav = new ModelAndView("booking");

		// System.out.println(request.getParameter("ftype"));
		//Validate that end time must be later than start time
		if(!checkEndTime(request.getParameter("stime"),request.getParameter("endtime")))
		{
			 mav.setViewName("redirect:home");
			 redir.addFlashAttribute("TimeErrorMessage","Booking not found");
		}
		
		mav.addObject("ftype", request.getParameter("ftype"));
		mav.addObject("date", request.getParameter("date"));
		mav.addObject("room", request.getParameter("room"));
		mav.addObject("stime", request.getParameter("stime"));
		mav.addObject("endtime", request.getParameter("endtime"));
		
		return mav;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView bookingPage() {
		ModelAndView mav = new ModelAndView("booking");

		ArrayList<Facility> facilityList = (ArrayList<Facility>) facilityService.findAllFacilities();
		ArrayList<Facility> fList2 = facilityService.findFacilitiesByFacilityType(1);
		
		ArrayList<FacilityType> typeList=typeService.findAllFacilityTypes();
		
		System.out.println("--TEST--");
		for (Facility facility : fList2) {
			System.out.println(facility.getFacilityName());
		}

		mav.addObject("facilityList", facilityList);
		
		mav.addObject("typeList", typeList);

		return mav;
	}
		
	@RequestMapping(value = "/typeid={typeid}", method = RequestMethod.GET)
	public ModelAndView Booking_TypeChosen(@PathVariable String typeid) 
	{
		ModelAndView mav = new ModelAndView("booking");
		
		ArrayList<Facility> facilityList = (ArrayList<Facility>) facilityService.findAllFacilities();
		
		ArrayList<FacilityType> typeList=typeService.findAllFacilityTypes();
		
		mav.addObject("facilityList", facilityList);
		
		mav.addObject("typeList", typeList);
		
		int TypeId=Integer.valueOf(typeid);
		
		mav.addObject("typeidchosen", TypeId);
		
		return mav;
		
	}
	
	
	
	
	@RequestMapping(value = "tid={tid}/fid={fid}", method = RequestMethod.GET)
	public ModelAndView Booking_FacilityChosen(@PathVariable  String fid ,@PathVariable String tid ) 
	{
		ModelAndView mav = new ModelAndView("booking");
		
		ArrayList<Facility> facilityList = (ArrayList<Facility>) facilityService.findAllFacilities();
		
		ArrayList<FacilityType> typeList=typeService.findAllFacilityTypes();
		
		mav.addObject("facilityList", facilityList);
		
		mav.addObject("typeList", typeList);
				
         int fId=Integer.valueOf(fid);
		
		mav.addObject("fidchosen", fId);
		
		  int tId=Integer.valueOf(tid);
			
			mav.addObject("typeidchosen", tId);
		
		
		
		return mav;
		
	}
	
	

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView bookingListPage() {
		ModelAndView mav = new ModelAndView("booking-list");
		ArrayList<Booking> bookingList = bService.findAllBookings();

		mav.addObject("bookingList", bookingList);
		return mav;
	}
	
	public boolean checkEndTime(String start, String end)
	{
		LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern("hh:mm a"));
		LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern("hh:mm a"));
		if(endTime.isAfter(startTime)) return true;
		else return false;

            
	}
}
