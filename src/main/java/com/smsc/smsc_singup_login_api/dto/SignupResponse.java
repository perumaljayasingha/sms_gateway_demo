package com.smsc.smsc_singup_login_api.dto;

public class SignupResponse {

	private String message;

	public SignupResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
