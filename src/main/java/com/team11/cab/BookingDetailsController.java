package com.team11.cab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.team11.cab.service.BookingService;

@Controller
public class BookingDetailsController {
	
	@Autowired
	private BookingService bService;
	
	
@RequestMapping(value="/bookingdetails", method={ RequestMethod.POST, RequestMethod.GET } )
	public ModelAndView searchBooking(@RequestParam String booking_id, RedirectAttributes redir, ModelAndView modelAndView) {
		
		
	    //validate input not empty
		if(booking_id.isEmpty())
		{
			 modelAndView.setViewName("redirect:home");
			 redir.addFlashAttribute("ErrorMessage","Please enter Booking ID");
			 return modelAndView;
		}
		int id = Integer.parseInt(booking_id);
		
		//validate booking exists
		if(!bService.validateBookings(id))
		{
			 modelAndView.setViewName("redirect:home");
			 redir.addFlashAttribute("ErrorMessage","Booking not found");	  
		}
		//pass booking object to booking-details view
		else
		{	
			modelAndView.setViewName("booking-details");
			modelAndView.addObject("booking",bService.findBookingByID(id));
		
		}
		
		 return modelAndView;
	}

}
