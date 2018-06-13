package com.team11.cab;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.team11.cab.model.Member;
import com.team11.cab.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	private MemberService memberService;
	
	@InitBinder
	public void initBinder(final WebDataBinder binder){
	  final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	  binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {

		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		Member member = new Member();

		modelAndView.addObject("member", member);
		modelAndView.setViewName("register");

		return modelAndView;

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute @Valid Member member, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Member userExists = memberService.findMemberByUsername(member.getUsername());

		if (userExists != null) {
			bindingResult.rejectValue("username", "error.user",
					"There is already a user registered with the username provided");
		}

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register");
		} else {
			memberService.saveMember(member);
			modelAndView.addObject("successMessage", "You have successfully registered!");
			modelAndView.setViewName("login");

		}
		return modelAndView;
	}
}
