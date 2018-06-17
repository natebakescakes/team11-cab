package com.team11.cab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.team11.cab.model.Member;
import com.team11.cab.service.MemberService;

@Controller
@RequestMapping(value = "/admin/members")
public class MemberController {

	@Autowired
	private MemberService mService;
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String memberUpdate(@RequestBody Member m) {
		mService.editMember(m);
		return "view-members";
}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String membersList() {

		return "view-members";
	}

}
