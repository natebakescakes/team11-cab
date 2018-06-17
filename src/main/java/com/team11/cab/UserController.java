package com.team11.cab;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team11.cab.model.Booking;
import com.team11.cab.model.Member;
import com.team11.cab.service.BookingService;
import com.team11.cab.service.MemberService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookingService bookingService;
	
	

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String viewMemberProfile(Model model, Authentication authentication) {

		model.addAttribute("member", memberService.findMemberByUsername(authentication.getName()));

		return "view-profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.GET)
	public String editMemberProfile(Model model, Authentication authentication) {

		model.addAttribute("member", memberService.findMemberByUsername(authentication.getName()));

		return "edit-profile";
	}

	@RequestMapping(value = "/profile/edit", method = RequestMethod.POST)
	public ModelAndView saveMemberProfile(@ModelAttribute Member member, BindingResult bindingResult, Authentication authentication) {
		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			System.out.println("HELLOHELLOHELLOHELLOHELLOHELLOHELLOHELLO");
			modelAndView.setViewName("edit-profile");
		} else {
			memberService.updateMember(member);
			modelAndView.addObject("successMessage", "Profile successfully saved!");
			modelAndView.setViewName("view-profile");

		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/booking", method = RequestMethod.GET)
	public String membermybookingsList() {
		return "membooking-list";
	}

	
	@RequestMapping(value = "/booking/cancel", method = RequestMethod.POST)
	public String memberBook(@RequestBody String id) {
		
		int ID = Integer.parseInt(id);
		
		Booking b = bookingService.findBookingByID(ID);
		b.setStatus("Cancelled");
		bookingService.changeBooking(b);
		return "membooking-list" ;
	}
}
