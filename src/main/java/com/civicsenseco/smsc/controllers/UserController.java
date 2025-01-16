package com.civicsenseco.smsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.civicsenseco.smsc.dto.LoginRequest;
import com.civicsenseco.smsc.dto.SMSwebResponse;
import com.civicsenseco.smsc.dto.SignupRequest;
import com.civicsenseco.smsc.services.UserService;

import jakarta.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request) {
		try {
            return service.signup(request);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
//		return ResponseEntity.ok(service.signup(request));
	}

	@PostMapping("/signin")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		try {
            SMSwebResponse response = service.login(request);
            if ("login Successfull..".equals(response.getMessage())) {
                return ResponseEntity.ok(response);
            } else if ("Password not match...".equals(response.getMessage())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
//		return ResponseEntity.ok(service.login(request));
}
