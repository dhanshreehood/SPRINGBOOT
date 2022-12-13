package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybage.model.RegistrationBean;

@Repository
public interface LoginRepository extends JpaRepository<RegistrationBean, Integer>{

//	RegistrationBean findUserByEmail(String email);
	
	//get all values of user by username
	 RegistrationBean findUserByUsername(String username);
			
	 @Query("SELECT u FROM RegistrationBean u WHERE u.username = :username")
	 public  List<RegistrationBean>  getUserByUsername(@Param("username") String username);
	 
	 @Query("SELECT u FROM RegistrationBean u WHERE u.username = :username AND u.password=:password")
	 public  RegistrationBean getDataForAuthentication(@Param("username") String username, @Param("password") String password);	 

}