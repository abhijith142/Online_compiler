package org.learnings.springBoot.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String signUpForm(Model model)
	{
		model.addAttribute("loginFormBean", new LoginFormBean());
		return "login";
	}
	
	@PostMapping("/login")
	public void login(@ModelAttribute LoginFormBean loginFormBean) {
		System.out.println(loginFormBean.getUserName());
		System.out.println(loginFormBean.getPassword());
	}
}
