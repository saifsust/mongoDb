package org.javawebdevelopment.models;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class Account {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String[] follower;
	private String[] post;
	private String[] appointment;
	private String[] geoLocation;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String firstName, String lastName, String email, String[] follower, String[] post,
			String[] appointment, String[] geoLocation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.follower = follower;
		this.post = post;
		this.appointment = appointment;
		this.geoLocation = geoLocation;
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

	public String[] getFollower() {
		return follower;
	}

	public void setFollower(String[] follower) {
		this.follower = follower;
	}

	public String[] getPost() {
		return post;
	}

	public void setPost(String[] post) {
		this.post = post;
	}

	public String[] getAppointment() {
		return appointment;
	}

	public void setAppointment(String[] appointment) {
		this.appointment = appointment;
	}

	public String[] getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String[] geoLocation) {
		this.geoLocation = geoLocation;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", follower=" + Arrays.toString(follower) + ", post=" + Arrays.toString(post) + ", appointment="
				+ Arrays.toString(appointment) + ", geoLocation=" + Arrays.toString(geoLocation) + "]";
	}

}
