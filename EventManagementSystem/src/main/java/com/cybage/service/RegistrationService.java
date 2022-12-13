package com.cybage.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cybage.model.RegistrationBean;
import com.cybage.repository.LoginRepository;
import com.cybage.repository.RegistrationRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class RegistrationService {
	
	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	LoginRepository loginRepository;

	@Autowired
	private JavaMailSender mailSender;

	public void register(RegistrationBean registrationBean, String siteURL)
			throws UnsupportedEncodingException, MessagingException {
		

		String randomCode = RandomString.make(15);
		registrationBean.setVerificationStatus(randomCode);
		registrationBean.setValidate(false);

		 registrationRepository.save(registrationBean);

		 sendVerificationEmail(registrationBean, siteURL);
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

	private void sendVerificationEmail(RegistrationBean registrationBean, String siteURL)
			throws MessagingException, UnsupportedEncodingException {
		String toAddress = registrationBean.getEmail();
		String fromAddress = "Trng2@evolvingsols.com";
		String senderName = "Rajwada's Event Management Pvt. Ltd.";
		String subject = "Welcome to EMS, please verify your account";

		String content = "<p> Hello " + registrationBean.getFirstName() + " " + registrationBean.getLastName() +",</p>";


		String verifyURL = siteURL + "/mainSystem/verify?code=" + registrationBean.getVerificationStatus();

		content += "<p>You registered an account on Rajwada's Event Management System, <br> before being able to use your account you need to verify your account by clicking here:</p>";
		content += "<h4> <a href=\"" + verifyURL + "\"> [link] </a> </h4>";
		content += "<p> Welcome to Rajwada's Event Management System</p>";
		content += "<p> Kind Regards, <br> Rajwada's Event Management Pvt. Ltd.</p>";

		MimeMessage message1 = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message1);

		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);

		helper.setText(content, true);

		mailSender.send(message1);

	}

	public boolean verify(String verificationStatus) {
		RegistrationBean registrationBean = registrationRepository.findByVerificationStatus(verificationStatus);

		if (registrationBean == null || registrationBean.getValidate()) {
			return false;
		} 
		else {
			registrationBean.setValidate(true);
			registrationBean.setVerificationStatus("Verified");
			registrationRepository.save(registrationBean);
			return true;
		}
	}

	//getAllUsers
	public List<RegistrationBean> getAllUsers() {
		return registrationRepository.findAll();
	}
	
	//getUserById
	public RegistrationBean getUserById(int registeredId)
	{
		return registrationRepository.findById(registeredId).orElse(null);
	}
	
	//deleteById
	public void deleteById(int registeredId)
	{
		registrationRepository.deleteById(registeredId);
	}
	
	//updateById
	public RegistrationBean updateById(int id, RegistrationBean registrationBean) {
		RegistrationBean user1=registrationRepository.findById(id).get();
		
		if(registrationBean.getRegistrationId()!=0)
			user1.getRegistrationId();
			
		if(registrationBean.getFirstName()!=null)
			user1.setFirstName(registrationBean.getFirstName());
		
		if(registrationBean.getLastName()!=null)
			user1.setLastName(registrationBean.getLastName());
			
		if(registrationBean.getUsername()!=null)
			user1.setUsername(registrationBean.getUsername());
		
		if(registrationBean.getEmail()!=null)
			user1.setEmail(registrationBean.getEmail());
		
		if(registrationBean.getPassword()!=null)
			user1.setPassword(registrationBean.getPassword());
		
		if(registrationBean.getContactNumber()!=null)
			user1.setContactNumber(registrationBean.getContactNumber());
		
		if(registrationBean.getAddress()!=null)
			user1.setAddress(registrationBean.getAddress());
		
		if(registrationBean.getRole()!=null)
			user1.getRole();
		
		return registrationRepository.save(user1);
	}
	
	//getByRole
	public List<RegistrationBean> getByOrganizer()
	{
		return registrationRepository.getByOrganizer();
	}
	
	public List<RegistrationBean> getByUser()
	{
		return registrationRepository.getByUser();
	}


}
