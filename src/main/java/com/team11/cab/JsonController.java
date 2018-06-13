package com.team11.cab;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team11.cab.model.Authority;
import com.team11.cab.model.Booking;
import com.team11.cab.model.Member;
import com.team11.cab.service.BookingService;
import com.team11.cab.service.MemberService;


@Controller
@RequestMapping(value = "/json/showmember")
public class JsonController {

	@Autowired
	private MemberService mService;
		
	@RequestMapping(value = "/jsonlist")
	@ResponseBody
	public ArrayList<Member> jsonMembers() 
	{
		return mService.findAllMember();
	}

	@Autowired
	private BookingService bService;
		
		
	@RequestMapping(value = "/jsonbookinglist")
	@ResponseBody
	public ArrayList<Booking> jsonBookings() 
	{
		return bService.findAllBookings();
	}
	
	@RequestMapping(value = "/jsonmybookinglist")
	@ResponseBody
	public ArrayList<Booking> jsonmyBookings(Authentication authentication) 
	{
		String username = authentication.getName();
		
		return bService.findMyBookings(username);
	}
}
