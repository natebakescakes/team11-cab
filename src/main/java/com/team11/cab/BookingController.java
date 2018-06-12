package com.team11.cab;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team11.cab.exception.BookingNotFound;
import com.team11.cab.exception.EmployeeNotFound;
import com.team11.cab.model.Booking;
import com.team11.cab.model.Department;
import com.team11.cab.model.Employee;
import com.team11.cab.model.Member;
import com.team11.cab.service.BookingService;
import com.team11.cab.service.MemberService;

@Controller
@RequestMapping(value="/booking")
public class BookingController {
	@Autowired
	private BookingService bService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView bookingListPage() 
	{
		ModelAndView mav = new ModelAndView("booking-list");
		ArrayList<Booking> bookingList = bService.findAllBookings();
		mav.addObject("bookingList", bookingList);
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView newBookingPage() {
		ModelAndView mav = new ModelAndView("booking-create", "booking", new Booking());
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewBooking(@ModelAttribute @Valid Booking booking, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("booking-create");

		ModelAndView mav = new ModelAndView();
		String message = "New booking " + booking.getBookingId() + " was successfully created.";

		bService.createBooking(booking);
		mav.setViewName("redirect:/booking/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployeePage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("booking-edit");
		Booking booking = bService.findBooking(id);
		mav.addObject("booking", booking);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEmployee(@ModelAttribute @Valid Booking booking, BindingResult result,
			@PathVariable String id, final RedirectAttributes redirectAttributes) throws BookingNotFound {

		if (result.hasErrors())
			return new ModelAndView("booking-edit");

		ModelAndView mav = new ModelAndView("redirect:/booking/list");
		String message = "Booking was successfully updated.";

		bService.changeBooking(booking);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteBooking(@PathVariable Integer id, final RedirectAttributes redirectAttributes)
			throws BookingNotFound 
	{	
		Booking booking = bService.findBooking(id);
		bService.removeBooking(booking);
		String message = "The booking " + booking.getBookingId() + " was successfully deleted.";
		redirectAttributes.addFlashAttribute("message", message);
		ModelAndView mav = new ModelAndView("redirect:/booking/list");
		return mav;
	}


}


	
