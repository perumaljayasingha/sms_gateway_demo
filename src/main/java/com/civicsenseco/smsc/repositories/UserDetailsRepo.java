package com.civicsenseco.smsc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.civicsenseco.smsc.entity.UserDetails;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {

	Optional<UserDetails> findByUsername(String username);
	boolean existsByUsername(String username);
}
