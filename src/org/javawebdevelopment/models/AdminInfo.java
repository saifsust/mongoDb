package org.javawebdevelopment.models;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "adminInfo")
public class AdminInfo {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String university;
	private String department;
	private String mobile;
	private String[] followers;
	private String[] post;
	private String[] appoinment;
	
	
	
	
	
	public AdminInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public AdminInfo(String id, String firstName, String lastName, String email, String university, String department,
			String mobile, String[] followers, String[] post, String[] appoinment) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.university = university;
		this.department = department;
		this.mobile = mobile;
		this.followers = followers;
		this.post = post;
		this.appoinment = appoinment;
	}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String[] getFollowers() {
		return followers;
	}
	public void setFollowers(String[] followers) {
		this.followers = followers;
	}
	public String[] getPost() {
		return post;
	}
	public void setPost(String[] post) {
		this.post = post;
	}
	public String[] getAppoinment() {
		return appoinment;
	}
	public void setAppoinment(String[] appoinment) {
		this.appoinment = appoinment;
	}
	@Override
	public String toString() {
		return "AdminInfo [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", university=" + university + ", department=" + department + ", mobile=" + mobile + ", followers="
				+ Arrays.toString(followers) + ", post=" + Arrays.toString(post) + ", appoinment="
				+ Arrays.toString(appoinment) + "]";
	}

	
	
	
}
