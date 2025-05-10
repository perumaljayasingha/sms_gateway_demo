package com.civicsenseco.smsc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.civicsenseco.smsc.entity.UserMaster;

@Repository
public interface UserMasterRepo extends JpaRepository<UserMaster, String>{

	UserMaster findByClientName (String username);
	boolean existsByClientName(String username);
}
