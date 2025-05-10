package com.civicsenseco.smsc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.civicsenseco.smsc.dto.LoginRequest;
import com.civicsenseco.smsc.dto.SMSwebResponse;
import com.civicsenseco.smsc.dto.SignupRequest;
import com.civicsenseco.smsc.dto.SignupResponse;
import com.civicsenseco.smsc.dto.UserProfile;
import com.civicsenseco.smsc.dto.UserProfileUpdateRequest;
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

	public UserProfile getProfile(String authToken) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserProfile updateProfile(String authToken, UserProfileUpdateRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public void logout(String authToken) {
		// TODO Auto-generated method stub
		
	}
	
	 // 7.1. Forgot Password - Request Reset Link
    public boolean forgotPassword(String email) {
        // 1.1 Verify if the email exists in the database
        // 1.2 If exists, generate a password reset token and send email with the link
        // 1.3 Return true if email is sent, false if email doesn't exist
        return true;  // Simulating success for now
    }

    // 7.2. Reset Password - Set New Password
    public boolean resetPassword(String token, String newPassword) {
        // 2.1 Validate the reset token
        // 2.2 If valid, update the user's password
        // 2.3 Return true if successful, false if invalid token
        return true;  // Simulating success for now
    }
	
	
}
