package com.cybage.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.exception.InvalidInputException;
import com.cybage.model.RegistrationBean;
import com.cybage.service.LoginService;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/")
	public ResponseEntity<RegistrationBean> login(@RequestBody  RegistrationBean user, 
													HttpServletRequest request){
		
		String username = user.getUsername();
		String password = user.getPassword();
		
		RegistrationBean loggedInUser = loginService.loginAuthentication(username, password);
		
		boolean verifyUsernameOfUser = loginService.checkUserByUsername(username);
		boolean flagToCheckPassword = loginService.checkPassword(user);
		
		if (!verifyUsernameOfUser) {
			throw new InvalidInputException("User does not exists..."); 
		}
		else if(verifyUsernameOfUser) {
			if(flagToCheckPassword) {
				if(loggedInUser.getLoginAttempt() == 3) {
					throw new InvalidInputException("Login attempt more than 3: Account Blocked...");
				}
				else if(!loggedInUser.getValidate()) {
					throw new InvalidInputException("User is not verified...");
				}
				else if(loggedInUser.getValidate()) {
					//login successful
					
					loginService.updateLoginAttempts(loggedInUser.getRegistrationId(), loggedInUser.getLoginAttempt());
					
					HttpSession session = request.getSession();
					
					session.setAttribute("registrationId", loggedInUser.getRegistrationId());
					session.setAttribute("username", loggedInUser.getUsername());
					session.setAttribute("firstname", loggedInUser.getFirstName());
					session.setAttribute("firstname", loggedInUser.getLastName());
					session.setAttribute("role", loggedInUser.getRole());
					
				}
			}
			else {
				throw new InvalidInputException("Incorrect credentials ...");
			}					
		}
		
		return new ResponseEntity<RegistrationBean>(loggedInUser, HttpStatus.OK);			
	}	
}
