package com.smsc.smsc_singup_login_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smsc.smsc_singup_login_api.dto.LoginRequest;
import com.smsc.smsc_singup_login_api.dto.SignupRequest;
import com.smsc.smsc_singup_login_api.services.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/signup")
	ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request) {
		return ResponseEntity.ok(service.signup(request));
	}

	@PostMapping("/signin")
	ResponseEntity<?> login(@RequestBody LoginRequest request) {
		return ResponseEntity.ok(service.login(request));
	}
}
