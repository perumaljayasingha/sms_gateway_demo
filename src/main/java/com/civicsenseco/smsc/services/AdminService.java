package com.civicsenseco.smsc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.civicsenseco.smsc.dto.UserProfile;
import com.civicsenseco.smsc.dto.UserProfileUpdateRequest;
import com.civicsenseco.smsc.repositories.UserDetailsRepo;

@Service
public class AdminService {

	@Autowired
	private UserDetailsRepo userDetailsRepo;
	
	 // 1. Update User Profile
    public UserProfile updateUserProfile(Long userId, UserProfileUpdateRequest request) {
    	UserProfile profile = new UserProfile();
//        UserDetails userDetails = userDetailsRepo.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
//
//        // Update user details
//        userDetails.setEmail(request.getEmail());
//        userDetails.setPhoneNumber(request.getPhoneNumber());
//        userDetails.setAddress(request.getAddress());
//        userDetailsRepo.save(userDetails);
//
//        // Map the updated entity to UserProfile DTO and return
//        return new UserProfile(userDetails.getId(), userDetails.getEmail(), userDetails.getPhoneNumber(), userDetails.getAddress());
    	return profile;
    }

    // 2. Delete User Profile
    public void deleteUserProfile(Long userId) {
//        UserDetails userDetails = userDetailsRepo.findById(userId)
//                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
//        userDetailsRepo.delete(userDetails);
    }
}
