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
	
	
@RequestMapping(value="/bookingdetails", method=RequestMethod.POST)
	public ModelAndView searchBooking(@RequestParam int booking_id, RedirectAttributes redir, ModelAndView modelAndView) {
		//declare booking service
		
	    //validate booking exists
		if(!bService.validateBookings(booking_id))
		{
			 modelAndView.setViewName("redirect:home");
			 redir.addFlashAttribute("ErrorMessage","Booking not found");
			    
			  
		}
		//else throw error and redirect user back to homepage
		else
		{	
			modelAndView.setViewName("booking-details");
			modelAndView.addObject("booking",bService.findBookingByID(booking_id));
		}
		
		  return modelAndView;
	}

}
