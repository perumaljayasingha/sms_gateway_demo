package com.smsc.smsc_singup_login_api.dto;

public class SMSwebResponse {

	private String username;
	private String message;
	
	public SMSwebResponse(String username, String message) {
		super();
		this.username = username;
		this.message = message;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
