package org.learnings.springBoot.login;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.learnings.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class LoginController {
	private final static Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	UserService userService;
	
	String destination = "./uploads/";
	
	@PostConstruct
	public void init() {
		if(! new File(destination).exists()) {
			logger.info("Creating Uploads directory");
			new File(destination).mkdir();
		}
	}
	
	@GetMapping("/signUp")
	public String signUpForm(Model model)
	{
		model.addAttribute("userFormBean", new UserFormBean());
		return "signUp";
	}
	
	@PostMapping("/signUp")
	public void signUp(@ModelAttribute UserFormBean userFormBean)
	{
		String displayPicPath = destination + userFormBean.getName();
		MultipartFile file = userFormBean.getDisplayPic();
		if(! new File(displayPicPath).exists()) {
			new File(displayPicPath).mkdir();
		}
		try {
			file.transferTo(new File(displayPicPath + "/" + file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//userService.signUp(userFormBean);
	}
}
