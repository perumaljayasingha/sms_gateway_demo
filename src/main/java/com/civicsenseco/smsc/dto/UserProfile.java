package com.civicsenseco.smsc.dto;

public class UserProfile {
	
	//View Profile DTO for user
	private String username;
    private String email;
//    private String firstName;
//    private String lastName;
    private String mobileNumber;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
    
}
