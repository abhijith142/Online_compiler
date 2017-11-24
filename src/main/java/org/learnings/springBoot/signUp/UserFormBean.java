package org.learnings.springBoot.signUp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class UserFormBean {
	private String name;
	private String fullName;
	private MultipartFile displayPic;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dob;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public MultipartFile getDisplayPic() {
		return displayPic;
	}
	public void setDisplayPic(MultipartFile displayPic) {
		this.displayPic = displayPic;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}
