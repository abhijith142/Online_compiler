package org.learnings.springBoot.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@GetMapping("/signUp")
	public String signUpForm(Model model)
	{
		model.addAttribute("userFormBean", new UserFormBean());
		return "signUp";
	}
	
	@PostMapping("/signUp")
	public void signUp(@ModelAttribute UserFormBean userFormBean)
	{
		System.out.println(userFormBean.getName());
		System.out.println(userFormBean.getFullName());
		System.out.println(userFormBean.getDisplayPic());
		System.out.println(userFormBean.getDob().toString());
	}
}
