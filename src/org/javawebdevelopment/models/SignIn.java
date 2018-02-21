package org.javawebdevelopment.models;

public class SignIn {
	private String userName;
	private String password;
	
	public SignIn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignIn(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignIn [userName=" + userName + ", password=" + password + "]";
	}
	
	
}
