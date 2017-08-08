package org.learnings.springBoot.login;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@RequestMapping(method=RequestMethod.GET,value="/signUp")
	public String signUpForm()
	{
		return "signUp";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/signUp")
	public void signUp(@ModelAttribute UserFormBean userFormBean)
	{
		
	}
}
