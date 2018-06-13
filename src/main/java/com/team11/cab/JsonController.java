package com.team11.cab;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team11.cab.model.Member;
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

}
