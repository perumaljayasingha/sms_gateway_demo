package com.civicsenseco.smsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.civicsenseco.smsc.dto.UserProfile;
import com.civicsenseco.smsc.dto.UserProfileUpdateRequest;
import com.civicsenseco.smsc.services.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class Admin {

//	@Autowired
	private final AdminService adminService;
	
	@Autowired
	public Admin(AdminService adminService)	{
		this.adminService = adminService;
	}
	
	// 1. Update User Profile
    @PutMapping("/user/{userId}")
    public ResponseEntity<?> updateUserProfile(@PathVariable Long userId, @Valid @RequestBody UserProfileUpdateRequest request) {
        try {
            UserProfile updatedProfile = adminService.updateUserProfile(userId, request);
            return ResponseEntity.ok(updatedProfile);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }

    // 2. Delete User Profile
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUserProfile(@PathVariable Long userId) {
        try {
            adminService.deleteUserProfile(userId);
            return ResponseEntity.ok("User profile deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
        }
    }
}
