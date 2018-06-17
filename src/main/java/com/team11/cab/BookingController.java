package com.team11.cab;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

	// Shares the same functionality of rendering the page
	@RequestMapping(value = "/booking", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView renderPage(HttpServletRequest request, RedirectAttributes redir, ModelAndView modelAndView) {

		ModelAndView mav = new ModelAndView("booking");
		
		// Display menu of Facility Types
		ArrayList<FacilityType> ftypes = facilityTypeService.findAllFacilityTypes();
		mav.addObject("ftypes", ftypes);

		// Display menu of Facilities
		ArrayList<Facility> facilities;
		
//		if(request.getParameter("typeId")==null || request.getParameter("date").isEmpty()) {
//			modelAndView.setViewName("redirect:home");
//			redir.addFlashAttribute("TimeErrorMessage", "Please enter BOTH facility type and date");
//			return modelAndView;
//		}
		
		if ((request.getParameter("typeId") != null) && (request.getParameter("date")!="")) {
			boolean showFacility = true;
			mav.addObject("showFacility", showFacility);
			String typeId = request.getParameter("typeId");
			mav.addObject("typeId", typeId);
			
			//do we still need this if facilities are retrieved by jquery?
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
		
		// add stime and endtime POST parameters
		mav.addObject("stime", request.getParameter("stime"));
		mav.addObject("endtime", request.getParameter("endtime"));

		return mav;
	}
	
	@RequestMapping(value = "/booking", method = RequestMethod.POST, params = { "submit" })
	public ModelAndView validateBooking(HttpServletRequest request, RedirectAttributes redir, ModelAndView modelAndView) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		int facilityId;

		// Convert POST attributes to the LocalDateTime objects
		LocalDate date = LocalDate.parse(request.getParameter("date"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalTime startTime = LocalTime.parse(request.getParameter("stime"), DateTimeFormatter.ofPattern("h:mm a"));
		LocalTime endTime = LocalTime.parse(request.getParameter("endtime"), DateTimeFormatter.ofPattern("h:mm a"));

		LocalDateTime startDateTime = LocalDateTime.of(date, startTime);
		LocalDateTime endDateTime = LocalDateTime.of(date, endTime);

		facilityId = Integer.parseInt(request.getParameter("facility"));

		// Make booking
		Booking b = new Booking();
		b.setFacility(facilityService.findFacilityById(facilityId));
		b.setTransDate(LocalDateTime.now());
		b.setStartDateTime(startDateTime);
		b.setEndDateTime(endDateTime);
		b.setMember(memberService.findMemberByUsername(username));
		b.setStatus("Booked");

		// if booking is valid
		if (bookingService.isBookingValid(b)) {
			// GET /bookingdetails
			modelAndView.setViewName("redirect:/user/submit");
			redir.addFlashAttribute("booking", b);
		} else {
			// GET /booking with bookingSuccess = false
			modelAndView.setViewName("redirect:/booking");
			redir.addAttribute("bookingSuccess", false);
			redir.addAttribute("typeId", request.getParameter("typeId"));
			redir.addAttribute("date", request.getParameter("date"));
			redir.addAttribute("stime", request.getParameter("stime"));
			redir.addAttribute("endtime", request.getParameter("endtime"));
		}
		// render booking.jsp
		return modelAndView;
	}
	
	@RequestMapping(value = "/user/submit", method = RequestMethod.GET)
	public ModelAndView makeBooking(
			@ModelAttribute("booking") final Booking booking,
			RedirectAttributes redir,
			ModelAndView mav) {

		// make the booking
		Booking newBooking = bookingService.makeBooking(booking);
		// redirect to /bookingdetails
		redir.addAttribute("booking_id", String.valueOf(newBooking.getBookingId()));
		mav.setViewName("redirect:/bookingdetails");
		return mav;
	}
	
	@RequestMapping(value = "/admin/booking", method = RequestMethod.GET)
	public String bookingsList() {
		return "booking-list";
	}

	@RequestMapping(value = "/admin/booking/booked", method = RequestMethod.POST)
	public String memberUpdate(@RequestBody String id) {
		
		int ID = Integer.parseInt(id);
		
		Booking b = bookingService.findBookingByID(ID);
		b.setStatus("Booked");
		bookingService.changeBooking(b);
		return "booking-list" ;
	}

	@RequestMapping(value = "/admin/booking/cancelled", method = RequestMethod.POST)
	public String memberBook(@RequestBody String id) {
		
		int ID = Integer.parseInt(id);
		
		Booking b = bookingService.findBookingByID(ID);
		b.setStatus("Cancelled");
		bookingService.changeBooking(b);
		return "booking-list" ;
	}
	
	@RequestMapping(value = "/admin/booking/maintenance", method = RequestMethod.POST)
	public String memberCancel(@RequestBody String id) {
		
		int ID = Integer.parseInt(id);
		System.out.println("GFSXHGXVFJHSXVJSBXHXB ID : "+ID);
		
		Booking b = bookingService.findBookingByID(ID);
		b.setStatus("Maintenance");
		bookingService.changeBooking(b);
		return "booking-list" ;
	}
	
	@RequestMapping(value = "/booking/fnamelist")
	public @ResponseBody List<Facility> getFacilities(@RequestParam(value="typeID", required=true) String typeId)
	{
		int id = Integer.parseInt(typeId);
		return facilityService.findFacilitiesByFacilityType(id);
	}
}
