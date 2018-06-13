package com.team11.cab;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import com.team11.cab.model.FacilityTypeSchedule;
import com.team11.cab.model.Slot;
import com.team11.cab.service.BookingService;
import com.team11.cab.service.FacilityService;
import com.team11.cab.service.FacilityTypeService;
import com.team11.cab.service.MemberService;

@RequestMapping(value = "/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingService bookingService;
	@Autowired
	private FacilityService facilityService;
	@Autowired
	private FacilityTypeService facilityTypeService;
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "", method = RequestMethod.POST, params={"refresh"})
	public ModelAndView refreshPage(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("booking");
		
		// Display menu of Facility Types
		ArrayList<FacilityType> ftypes = facilityTypeService.findAllFacilityTypes();
		mav.addObject("ftypes", ftypes);
		
		// Display menu of Facilities
		ArrayList<Facility> facilities;
		if ((request.getParameter("typeId") != null) && (request.getParameter("date") != "")) {
			String typeId = request.getParameter("typeId");
			mav.addObject("typeId", typeId);
			int typeIdNum = Integer.parseInt(typeId);
			facilities = facilityService.findFacilitiesByFacilityType(typeIdNum);
			mav.addObject("facilities", facilities);
			
			LocalDate date = LocalDate.parse(request.getParameter("date"),
					DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			mav.addObject("date", request.getParameter("date"));

			// Display schedule for all (relevant) Facilities
			ArrayList<FacilityTypeSchedule> allFacilitySchedules = new ArrayList<FacilityTypeSchedule>();
			
			for (Facility facility : facilities) {
				String facilityName = facility.getFacilityName();
				ArrayList<Slot> schedule = bookingService.makeFacilityDaySchedule(facility.getFacilityId(), date);
				allFacilitySchedules.add(new FacilityTypeSchedule(facilityName, facility.getFacilityId(), schedule));
			}
			mav.addObject("facilitySchedules", allFacilitySchedules);
		}
		
		mav.addObject("stime", request.getParameter("stime"));
		mav.addObject("endtime", request.getParameter("endtime"));

		return mav;
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST, params={"submit"})
	public ModelAndView bookingPostPage(HttpServletRequest request, RedirectAttributes redir, ModelAndView modelAndView) {
		
		// Render view
		ModelAndView mav = new ModelAndView("booking");
		
		int userId = 1; // TODO: Change this when you can get userId
		boolean bookingSuccess;
		int facilityId;
		
		// Convert POST attributes to the LocalDateTime objects
		LocalDate date = LocalDate.parse(request.getParameter("date"),
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalTime startTime = LocalTime.parse(request.getParameter("stime"), DateTimeFormatter.ofPattern("h:mm a"));
		LocalTime endTime = LocalTime.parse(request.getParameter("endtime"), DateTimeFormatter.ofPattern("h:mm a"));
		
		LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
		LocalDateTime endDateTime = LocalDateTime.of(date, endTime);
		
		facilityId = Integer.parseInt(request.getParameter("facility"));
		
		// Make booking
		Booking b = new Booking();
		b.setFacility(facilityService.findFacilityById(facilityId));
		b.setStartDateTime(startDateTime);
		b.setEndDateTime(endDateTime);
		b.setMember(memberService.findMemberById(userId));
		
		if (bookingService.isBookingValid(b)) {
			bookingService.makeBooking(b);
			bookingSuccess = true;
		} else {
			bookingSuccess = false;
		}
		
//		// Test booking
//		Booking b = new Booking();
//		b.setFacility(facilityService.findFacilityById(1));
//		b.setStartDate(LocalDateTime.of(2018, 6, 12, 8, 0));
//		b.setEndDate(LocalDateTime.of(2018, 6, 12, 10, 0));
//		b.setUser(memberService.findMemberById(1));
		
		// Display menu of Facility Types
		ArrayList<FacilityType> ftypes = facilityTypeService.findAllFacilityTypes();
		mav.addObject("ftypes", ftypes);
		
		// Display menu of Facilities
		ArrayList<Facility> facilities;
		if (request.getParameter("typeId") != null) {
			String typeId = request.getParameter("typeId");
			int typeIdNum = Integer.parseInt(typeId);
			facilities = facilityService.findFacilitiesByFacilityType(typeIdNum);
			mav.addObject("facilities", facilities);
			mav.addObject("typeId", typeId);
			
			// Display schedule for all (relevant) Facilities
			ArrayList<FacilityTypeSchedule> allFacilitySchedules = new ArrayList<FacilityTypeSchedule>();
			
			for (Facility facility : facilities) {
				String facilityName = facility.getFacilityName();
				ArrayList<Slot> schedule = bookingService.makeFacilityDaySchedule(facility.getFacilityId(), date);
				allFacilitySchedules.add(new FacilityTypeSchedule(facilityName, facility.getFacilityId(), schedule));
			}
			mav.addObject("facilitySchedules", allFacilitySchedules);
		}
		
		mav.addObject("date", request.getParameter("date"));
		
		// pass-through values
		if (bookingSuccess == false) {
			mav.addObject("stime", request.getParameter("stime"));
			mav.addObject("endtime", request.getParameter("endtime"));
			mav.addObject("bookingSuccess", bookingSuccess);
			return mav;
		} else {
			modelAndView.setViewName("redirect:/bookingdetails");
			redir.addAttribute("booking_id", "20");
			return modelAndView;
		}
		

		
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView bookingPage(HttpServletRequest request) {
		
//		// Tests for Booking		
//		LocalDateTime start1 = LocalDateTime.of(2018, 6, 12, 8, 0);
//		LocalDateTime end1 = LocalDateTime.of(2018, 6, 12, 9, 0);
//		
//		LocalDateTime start2 = LocalDateTime.of(2018, 6, 12, 10, 0);
//		LocalDateTime end2 = LocalDateTime.of(2018, 6, 12, 12, 0);
//		
//		System.out.println("--TEST 1--");
//		System.out.println(bookingService.isBookingValid(start1, end1, start2, end2));
//		
//		end1 = LocalDateTime.of(2018, 6, 12, 10, 0);
//
//		System.out.println("--TEST 2--");
//		System.out.println(bookingService.isBookingValid(start1, end1, start2, end2));
//		
//		end1 = LocalDateTime.of(2018, 6, 12, 11, 0);
//
//		System.out.println("--TEST 3--");
//		System.out.println(bookingService.isBookingValid(start1, end1, start2, end2));
				
		ModelAndView mav = new ModelAndView("booking");

		ArrayList<FacilityType> ftypes = facilityTypeService.findAllFacilityTypes();
		mav.addObject("ftypes", ftypes);
		
		mav.addObject("date", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		boolean hideFacility = true;
		mav.addObject("hideFacility", hideFacility);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView bookingListPage() {
		ModelAndView mav = new ModelAndView("booking-list");
		ArrayList<Booking> bookingList = bookingService.findAllBookings();
		mav.addObject("bookingList", bookingList);
		return mav;
	}

	@RequestMapping(value = "/typeid={typeid}", method = RequestMethod.GET)
	public ModelAndView Booking_TypeChosen(@PathVariable String typeid) 
	{
		ModelAndView mav = new ModelAndView("booking");
		
		ArrayList<Facility> facilityList = (ArrayList<Facility>) facilityService.findAllFacilities();
		
		ArrayList<FacilityType> typeList= facilityTypeService.findAllFacilityTypes();
		
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
		
		ArrayList<FacilityType> typeList= facilityTypeService.findAllFacilityTypes();
		
		mav.addObject("facilityList", facilityList);
		
		mav.addObject("typeList", typeList);
				
         int fId=Integer.valueOf(fid);
		
		mav.addObject("fidchosen", fId);
		
		  int tId=Integer.valueOf(tid);
			
			mav.addObject("typeidchosen", tId);
		
		
		
		return mav;
		
	}
}
