package org.learnings.springBoot.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	@Id
	private int id;
	@Indexed(unique=true)
	private String name;
	private String fullName;
	private String displayPic;
	private Date dob;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getDisplayPic() {
		return displayPic;
	}
	public void setDisplayPic(String displayPic) {
		this.displayPic = displayPic;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public User(String name, String fullName, String displayPic, Date dob) {
		super();
		this.name = name;
		this.fullName = fullName;
		this.displayPic = displayPic;
		this.dob = dob;
	}
	@Override
    public String toString() {
        return "User{" +
        		", id ='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
