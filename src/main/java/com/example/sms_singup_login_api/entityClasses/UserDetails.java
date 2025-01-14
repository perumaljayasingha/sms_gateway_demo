package com.example.sms_singup_login_api.entityClasses;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userdetails")
public class UserDetails {

	@Id
	@Column(name = "id", nullable = false, length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username", length = 50, unique = true)
	private String username;
	@Column(name = "mobilenumber", length = 15)
	private String mobileNumber;
	@Column(name = "email", length = 100)
	private String email;
	@Column(name = "defaultsenderid", length = 20)
	private String defaultSenderId;
	@Column(name = "question", length = 60)
	private String question;
	@Column(name = "answer", length = 100)
	private String answer;
	@Column(name = "status", length = 11)
	private int status = 0;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDefaultSenderId() {
		return defaultSenderId;
	}
	public void setDefaultSenderId(String defaultSenderId) {
		this.defaultSenderId = defaultSenderId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
