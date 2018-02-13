package org.javawebdevelopment.models;

import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class GeoLocation {

	@Id
	private String id;
	private double[] postion;
	private String locationName;
	private Date currentLocationTime;
	private Date loginTime;
	private Date logoutTime;

	public GeoLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeoLocation(double[] postion, String locationName, Date currentLocationTime, Date loginTime,
			Date logoutTime) {
		super();
		this.postion = postion;
		this.locationName = locationName;
		this.currentLocationTime = currentLocationTime;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double[] getPostion() {
		return postion;
	}

	public void setPostion(double[] postion) {
		this.postion = postion;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public Date getCurrentLocationTime() {
		return currentLocationTime;
	}

	public void setCurrentLocationTime(Date currentLocationTime) {
		this.currentLocationTime = currentLocationTime;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Date getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(Date logoutTime) {
		this.logoutTime = logoutTime;
	}

	@Override
	public String toString() {
		return "GeoLocation [id=" + id + ", postion=" + Arrays.toString(postion) + ", locationName=" + locationName
				+ ", currentLocationTime=" + currentLocationTime + ", loginTime=" + loginTime + ", logoutTime="
				+ logoutTime + "]";
	}

}
