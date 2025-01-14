package com.example.sms_singup_login_api.repositoryClasses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sms_singup_login_api.entityClasses.UserMaster;

@Repository
public interface UserMasterRepo extends JpaRepository<UserMaster, String>{

	UserMaster findByClientName (String username);
	boolean existsByClientName(String username);
}
