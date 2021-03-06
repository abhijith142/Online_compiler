package org.learnings.springBoot.signUp;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.learnings.springBoot.dto.User;
import org.learnings.springBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SignUpController {
	private final static Logger logger = Logger.getLogger(SignUpController.class);
	@Autowired
	UserService userService;
	@Autowired 
	ServletContext context;

	String destination;
	
	@PostConstruct
	public void init() {
		destination =  context.getRealPath("/uploads/");
		logger.info(destination);
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
		String displayPicLocation =  destination + userFormBean.getName();
		MultipartFile file = userFormBean.getDisplayPic();
		if(! new File(displayPicLocation).exists()) {
			new File(displayPicLocation).mkdir();
		}
		try {
			file.transferTo(new File(displayPicLocation + "/" + file.getOriginalFilename()));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = new User(userFormBean.getName(),userFormBean.getFullName(),displayPicLocation,userFormBean.getDob());
		userService.signUp(user);
	}
}
