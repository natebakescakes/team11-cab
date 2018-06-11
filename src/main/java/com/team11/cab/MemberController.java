package com.team11.cab;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@InitBinder
	private void initRoleBinder(WebDataBinder binder) {
		
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String membersList() {
		
		return "view-members";
	}
	
	
	
}
