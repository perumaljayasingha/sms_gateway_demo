package com.civicsenseco.smsc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.civicsenseco.smsc.dto.LoginRequest;
import com.civicsenseco.smsc.dto.SMSwebResponse;
import com.civicsenseco.smsc.dto.SignupRequest;
import com.civicsenseco.smsc.dto.SignupResponse;
import com.civicsenseco.smsc.entity.UserDetails;
import com.civicsenseco.smsc.entity.UserMaster;
import com.civicsenseco.smsc.repositories.UserDetailsRepo;
import com.civicsenseco.smsc.repositories.UserMasterRepo;

@Service
public class UserService {

	@Autowired
	private UserMasterRepo masterRepo;
	
	@Autowired
	private UserDetailsRepo detailsRepo;
		
	public ResponseEntity<?> signup(SignupRequest request)	{
		if (!isValidEmail(request.getUsername())) {
            return ResponseEntity.badRequest().body("Invalid email format"); // 400 Bad Request
        }
        if (detailsRepo.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists"); // 400 Bad Request
        }

        UserDetails details = new UserDetails();
        details.setUsername(request.getUsername());
        details.setEmail(request.getUsername());
        detailsRepo.save(details);

        String hashedPassword = Base64Utils.encodeToBase64(request.getPassword());
        UserMaster master = new UserMaster();
        master.setPassword(hashedPassword);
        master.setMasterId(String.valueOf(details.getId()));
        master.setClientName(details.getUsername());
        masterRepo.save(master);

        return ResponseEntity.status(201).body(new SignupResponse("SignUp Successfully...")); // 201 Created

	}
	
	private boolean isValidEmail(String username) {
	    return username != null && username.contains("@");
	}
	
	public SMSwebResponse login(LoginRequest loginRequest)	{
		if (!masterRepo.existsByClientName(loginRequest.getUsername())) {
            return new SMSwebResponse(loginRequest.getUsername(), "login failed..User name not registered");
        }

        UserMaster user = masterRepo.findByClientName(loginRequest.getUsername());
        String decodedPassword = Base64Utils.decodeFromBase64(user.getPassword());

        if (!decodedPassword.equals(loginRequest.getPassword())) {
            return new SMSwebResponse(user.getClientName(), "Password not match...");
        }

        return new SMSwebResponse(user.getClientName(), "login Successfull..");
	}
}
