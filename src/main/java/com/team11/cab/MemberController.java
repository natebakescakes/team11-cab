package com.team11.cab;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String memberUpdate(@RequestBody Member m, HttpServletRequest request) {
		// mav=new ModelAndView();
		System.out.println("Before update" + m.getFirstName());
		mService.updateMember(m);

		return "view-members";
		// mav.setViewName("redirect:/member/list");

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String membersList() {

		return "view-members";
	}

}
