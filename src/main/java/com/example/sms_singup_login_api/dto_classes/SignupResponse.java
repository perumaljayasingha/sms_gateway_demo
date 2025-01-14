package com.example.sms_singup_login_api.dto_classes;

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
