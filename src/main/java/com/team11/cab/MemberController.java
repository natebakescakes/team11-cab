package com.team11.cab;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team11.cab.model.Member;
import com.team11.cab.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

	@Autowired
	private MemberService mService;
	
	@InitBinder
	private void initRoleBinder(WebDataBinder binder) {
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView membersListPage() 
	{
		ModelAndView mav = new ModelAndView("view-members");
		ArrayList<Member> members = mService.findAllMember();
		mav.addObject("members", members);
		return mav;
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String memberProfile(Model model, Authentication authentication) {
		
		model.addAttribute("member", mService.findMemberByUsername(authentication.getName()));
		
		return "member-profile";
	}

}
