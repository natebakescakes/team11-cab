package com.team11.cab;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	private FacilityTypeService facilityTypeService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ModelAndView bookingPostPage(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView("booking");
		
		ArrayList<FacilityType> ftypes = facilityTypeService.findAllFacilityTypes();
		
		System.out.println(request.getParameter("ftype"));
		
		// Display "Choose Room" dropdown by Facility Type
		int typeId = Integer.parseInt(request.getParameter("ftype"));
		ArrayList<Facility> rooms = facilityService.findFacilitiesByFacilityType(typeId);
		
		mav.addObject("typeId", typeId);
		mav.addObject("ftypes", ftypes);
		mav.addObject("date", request.getParameter("date"));
		mav.addObject("rooms", rooms);
		mav.addObject("stime", request.getParameter("stime"));
		mav.addObject("endtime", request.getParameter("endtime"));

		return mav;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView bookingPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("booking");

		ArrayList<FacilityType> ftypes = facilityTypeService.findAllFacilityTypes();

		ArrayList<Facility> rooms = facilityService.findFacilitiesByFacilityType(1);

		mav.addObject("ftypes", ftypes);
		mav.addObject("date", request.getParameter("date"));
		mav.addObject("rooms", rooms);
		mav.addObject("stime", request.getParameter("stime"));
		mav.addObject("endtime", request.getParameter("endtime"));

		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView bookingListPage() {
		ModelAndView mav = new ModelAndView("booking-list");
		ArrayList<Booking> bookingList = bService.findAllBookings();

		mav.addObject("bookingList", bookingList);
		return mav;
	}
}
