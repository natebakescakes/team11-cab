package com.team11.cab;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

	/*
	 * TODO: Includes test for isBookingValid
	 * */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView bookingPage(HttpServletRequest request) {
		
//		LocalDateTime start1 = LocalDateTime.of(2018, 6, 12, 8, 0);
//		LocalDateTime end1 = LocalDateTime.of(2018, 6, 12, 9, 0);
//		
//		LocalDateTime start2 = LocalDateTime.of(2018, 6, 12, 10, 0);
//		LocalDateTime end2 = LocalDateTime.of(2018, 6, 12, 12, 0);
//		
//		System.out.println("--TEST 1--");
//		System.out.println(bService.isBookingValid(start1, end1, start2, end2));
//		
//		end1 = LocalDateTime.of(2018, 6, 12, 10, 0);
//
//		System.out.println("--TEST 2--");
//		System.out.println(bService.isBookingValid(start1, end1, start2, end2));
//		
//		end1 = LocalDateTime.of(2018, 6, 12, 11, 0);
//
//		System.out.println("--TEST 3--");
//		System.out.println(bService.isBookingValid(start1, end1, start2, end2));
				
		ModelAndView mav = new ModelAndView("booking");

		ArrayList<FacilityType> ftypes = facilityTypeService.findAllFacilityTypes();

		mav.addObject("ftypes", ftypes);
		mav.addObject("date", LocalDate.now().toString());

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
