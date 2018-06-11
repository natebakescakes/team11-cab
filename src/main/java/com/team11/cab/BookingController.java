package com.team11.cab;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team11.cab.model.Booking;
import com.team11.cab.model.Facility;
import com.team11.cab.service.BookingService;


@RequestMapping(value="/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingService bService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView bookingPage() {
		ModelAndView mav = new ModelAndView("booking");
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
