package com.cybage.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.exception.InvalidInputException;
import com.cybage.model.RegistrationBean;
import com.cybage.repository.RegistrationRepository;
import com.cybage.service.RegistrationService;

@CrossOrigin("*")

@RestController
@RequestMapping("/mainSystem")
public class RegistrationController {
	

@Autowired RegistrationRepository registrationRepository;

@Autowired RegistrationService registrationService;

@PostMapping("/register")
public void register(@RequestBody RegistrationBean registrationBean,HttpServletRequest request) 
		throws UnsupportedEncodingException, MessagingException
{
		String username = registrationBean.getUsername();
		
		boolean verifyIfUsernameExists = registrationService.checkUserByUsername(username);
		
		if(!verifyIfUsernameExists) 
		{
				registrationService.register(registrationBean,getSiteURL(request));
				System.out.println("registered user");
		}
		else {
			throw new InvalidInputException("Username already exists... please try something else...");
		}
}

private String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
}

@GetMapping("/verify")
public ResponseEntity<String> activateAccount(@Param("code") String code)
{
	boolean isAccountVerified = registrationService.verify(code);
	if(isAccountVerified)
	{
		return new ResponseEntity<String>("Congratulations!! You're account have been successfully verified",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("You are not authorised to activate this account",HttpStatus.OK);
	}
}

@GetMapping("/getAllUsers")
public ResponseEntity<List<RegistrationBean>> getAllUsers()
{
	List<RegistrationBean> usersList =registrationService.getAllUsers();
	return new ResponseEntity<List<RegistrationBean>>(usersList,HttpStatus.OK);
}

@GetMapping("/getUserById/{id}")
public ResponseEntity<RegistrationBean> getUserById(@PathVariable int id)
{
	RegistrationBean registrationBean = registrationService.getUserById(id);
	return new ResponseEntity<RegistrationBean>(registrationBean,HttpStatus.OK);
} 

@DeleteMapping("/deleteById/{id}")
public ResponseEntity<String> deleteById(@PathVariable int id)
{
	registrationService.deleteById(id);
	return new ResponseEntity<String>("Deleted Successfully!",HttpStatus.CREATED);
}

@PutMapping("/updateById/{id}")
public ResponseEntity<String> updateById(@PathVariable int id,@RequestBody RegistrationBean registrationBean)
{
	registrationService.updateById(id, registrationBean);
	return new ResponseEntity<String>("Profile Update Successfully!!!",HttpStatus.CREATED);
}

@GetMapping("/getByOrganizer")
public ResponseEntity<List<RegistrationBean>> getByOrganizer()
{
	List<RegistrationBean> registrationBean = registrationService.getByOrganizer();
	return new ResponseEntity<List<RegistrationBean>>(registrationBean,HttpStatus.OK);
}

@GetMapping("/getByUser")
public ResponseEntity<List<RegistrationBean>> getByUser()
{
	List<RegistrationBean> registrationBean = registrationService.getByUser();
	return new ResponseEntity<List<RegistrationBean>>(registrationBean,HttpStatus.OK);
}

}
