package com.example.sms_singup_login_api.serviceClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sms_singup_login_api.dto_classes.LoginRequest;
import com.example.sms_singup_login_api.dto_classes.SMSwebResponse;
import com.example.sms_singup_login_api.dto_classes.SignupRequest;
import com.example.sms_singup_login_api.dto_classes.SignupResponse;
import com.example.sms_singup_login_api.entityClasses.UserDetails;
import com.example.sms_singup_login_api.entityClasses.UserMaster;
import com.example.sms_singup_login_api.repositoryClasses.UserDetailsRepo;
import com.example.sms_singup_login_api.repositoryClasses.UserMasterRepo;

@Service
public class UserService {

	@Autowired
	private UserMasterRepo masterRepo;
	
	@Autowired
	private UserDetailsRepo detailsRepo;
	
	public ResponseEntity<?> signup(SignupRequest request)	{
		UserDetails details = new UserDetails();
		details.setUsername(request.getUsername());
		details.setEmail(request.getUsername());
		if (!isValidEmail(request.getUsername())) {
	        return ResponseEntity.badRequest().body("Invalid email format");
	    }
		if(detailsRepo.existsByUsername(request.getUsername()))	{
			return ResponseEntity.badRequest().body("User name is already exists");
		}
		detailsRepo.save(details);
		
		UserMaster master = new UserMaster();
		master.setPassword(request.getPassword());
		master.setMasterId(String.valueOf(details.getId()));
		master.setClientName(details.getUsername());
		masterRepo.save(master);
		return ResponseEntity.ok(new SignupResponse("SignUp Successfully..."));
	}
	
	private boolean isValidEmail(String username) {
	    return username != null && username.contains("@");
	}
	
	public SMSwebResponse login(LoginRequest loginRequest)	{
//		Optional<UserDetails> optional = detailsRepo.findByUserName(loginRequest.getUserName());
//		if(detailsRepo.existsByUserName(loginRequest.getUserName()))	{
//			UserDetails details = optional.get();
//			if(Objects.nonNull(details.getUserMaster()) && 
//					details.getUserMaster().getPassword().equals(loginRequest.getPassword())) {
//				return new SMSwebResponse(details.getUserName(), "login Successfull..");
//			}
//			else {
//				return new SMSwebResponse(details.getUserName(), "Password not match...");
//			}			
//		}
//		return new SMSwebResponse(loginRequest.getUserName(), "login failed..User name not Registerd");
		UserMaster optional = masterRepo.findByClientName(loginRequest.getUsername());
		if(masterRepo.existsByClientName(loginRequest.getUsername())) {
			if(optional.getPassword().equals(loginRequest.getPassword())) {
				return new SMSwebResponse(optional.getClientName(), "login Successfull..");
			}
			else {
				return new SMSwebResponse(optional.getClientName(), "Password not match...");
			}
		}
		return new SMSwebResponse(loginRequest.getUsername(), "login failed..User name not Registerd");
	}
}
