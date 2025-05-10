package com.civicsenseco.smsc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.civicsenseco.smsc.dto.MessageResponse;
import com.civicsenseco.smsc.dto.RoleAssignRequest;
import com.civicsenseco.smsc.dto.TokenRefreshRequest;
import com.civicsenseco.smsc.services.RoleService;

@RestController
@RequestMapping("/role")
public class Role {

	@Autowired
	private RoleService roleService;
	
	// 1. Add a new role
    @PostMapping("/add")
    public ResponseEntity<?> addRole(@RequestBody String roleName) {
        try {
            roleService.addRole(roleName);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MessageResponse("Role added successfully."));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    // 2. Assign a role to a user
    @PutMapping("/assign")
    public ResponseEntity<?> assignRoleToUser(@RequestBody RoleAssignRequest request) {
        try {
            roleService.assignRoleToUser(request.getUsername(), request.getRoleName());
            return ResponseEntity.ok(new MessageResponse("Role assigned successfully."));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    // 3. Refresh Token
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody TokenRefreshRequest request) {
        try {
            String newToken = roleService.refreshToken(request.getRefreshToken());
            return ResponseEntity.ok(new MessageResponse("Token refreshed successfully: " + newToken));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse(e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }
}
