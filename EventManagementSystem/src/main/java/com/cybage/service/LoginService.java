package com.cybage.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.RegistrationBean;
import com.cybage.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	LoginRepository loginRepository;
	
	//getting user by username
	public RegistrationBean getUserByUsername(String username) {
		return loginRepository.findUserByUsername(username);
	}
	
	//check if user exists by given username 
	public boolean checkUserByUsername(String username) {
		RegistrationBean userData = loginRepository.findUserByUsername(username);
		
		if(userData != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//check if given password by login is same for the username
	public boolean checkPassword(RegistrationBean user) {
		
//		check if username exists
		boolean flag = checkUserByUsername(user.getUsername());
		
//		if yes
		if(flag) {
			return getUserByUsername(user.getUsername()).getPassword().equals(user.getPassword());
		}
		
		else {
			return false;
		}	
		
		}
	
	public RegistrationBean loginAuthentication(String username, String password) {
		return loginRepository.getDataForAuthentication(username, password);
	}

	//login attempt
	public boolean updateLoginAttempts(int id,int attempts) {
		RegistrationBean user = loginRepository.findById(id).get();
		user.setLoginAttempt(attempts);
		loginRepository.save(user);
		return true;
	}
			
	//generate otp for login
	public static Integer generateOTP() {
		Random random = new Random();
        int num = random.nextInt(100000);
        String formatted = String.format("%05d", num);
        return Integer.parseInt(formatted);
	}
	
}	