package com.civicsenseco.smsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.civicsenseco.smsc.dto.ForgotPasswordRequest;
import com.civicsenseco.smsc.dto.LoginRequest;
import com.civicsenseco.smsc.dto.MessageResponse;
import com.civicsenseco.smsc.dto.ResetPasswordRequest;
import com.civicsenseco.smsc.dto.SMSwebResponse;
import com.civicsenseco.smsc.dto.SignupRequest;
import com.civicsenseco.smsc.dto.UserProfile;
import com.civicsenseco.smsc.dto.UserProfileUpdateRequest;
import com.civicsenseco.smsc.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class User {
	
	@Autowired
	private UserService service;
	
	// 1. User Registration (Signup)
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

	// 2. User Login (Signin)
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
	
	// 3. Email Verification
	@Operation(summary = "Get an example")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved the example"),
        @ApiResponse(responseCode = "400", description = "", content = {}),  // Suppress details for 400
        @ApiResponse(responseCode = "404"),
//        @ApiResponse(responseCode = "500")
    })
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "Successfully retrieved the example"),
//			@ApiResponse(responseCode = "400", description = "Bad Request - Invalid input"),
//			@ApiResponse(responseCode = "404", description = "Not Found - Example not found"),
//			@ApiResponse(responseCode = "500", description = "Internal Server Error")
//	})
    @GetMapping("/verify")
    public ResponseEntity<?> verifyEmail(@RequestParam("token") String token) {
//        try {
//            boolean isVerified = service.verifyEmail(token);
//            if (isVerified) {
//                return ResponseEntity.ok(new MessageResponse("Email verified successfully."));
//            } else {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Invalid or expired verification token."));
//            }
//        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
//        }
    }

    // 4. View Profile (GET)
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization") String authToken) {
        try {
            UserProfile profile = service.getProfile(authToken);
            return ResponseEntity.ok(profile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    // 5. Update Profile (PUT)
    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(@RequestHeader("Authorization") String authToken, @RequestBody UserProfileUpdateRequest request) {
        try {
            UserProfile updatedProfile = service.updateProfile(authToken, request);
            return ResponseEntity.ok(updatedProfile);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    // 6. Logout (POST)
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authToken) {
        try {
            service.logout(authToken);
            return ResponseEntity.ok(new MessageResponse("Logged out successfully."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
    
    // 7.1. Forgot Password - Request Reset Link
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        try {
            boolean emailSent = service.forgotPassword(request.getEmail());
            if (emailSent) {
                return ResponseEntity.ok(new MessageResponse("Password reset link has been sent to your email."));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageResponse("Email not found."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    // 7.2. Reset Password - Set New Password
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {
        try {
            boolean passwordReset = service.resetPassword(request.getToken(), request.getNewPassword());
            if (passwordReset) {
                return ResponseEntity.ok(new MessageResponse("Password has been reset successfully."));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Invalid or expired reset token."));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}
