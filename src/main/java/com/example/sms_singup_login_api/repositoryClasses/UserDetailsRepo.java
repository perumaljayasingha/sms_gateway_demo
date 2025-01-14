package com.example.sms_singup_login_api.repositoryClasses;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sms_singup_login_api.entityClasses.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {

	Optional<UserDetails> findByUsername(String username);
	boolean existsByUsername(String username);
}
