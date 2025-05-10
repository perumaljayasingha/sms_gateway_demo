package com.civicsenseco.smsc.dto;

public class MessageResponse {

	// Simple Message Response
	 private String message;

	public MessageResponse(String message) {
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
