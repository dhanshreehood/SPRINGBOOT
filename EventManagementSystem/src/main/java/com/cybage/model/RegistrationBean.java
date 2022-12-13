package com.cybage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="registration_table_EMS")
public class RegistrationBean {
	
	@Id
	@GeneratedValue
	private int registrationId;

	@Column(nullable = false, unique = true, length = 45)
	private String username;
	
	@Column(nullable = false, length = 20)
	private String firstName;
	
	@Column(nullable = false, length = 20)
	private String lastName;
	
	@Column(nullable = false, length = 45)
	private String email;
	
	@Column(nullable = false, length = 25)
	private String password;
	
	@Column(nullable = false, length = 60)
	private String address;
	
	@Column(nullable = false, length = 10)
	private String contactNumber;
	
	@Column(nullable = false, length = 20)
	private String role;
	
	@Column(name="login_attempt", columnDefinition = "integer default 0")
	private int loginAttempt;
	
	@OneToMany(mappedBy= "userComplaint", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ComplaintBean> complaintBeans;
	
	@OneToMany(mappedBy= "eventOrganizer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<EventBean> eventBeans;
	
	@OneToMany(mappedBy= "admin", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<AdminBean> category;
	
	@OneToMany(mappedBy= "eventOrganizer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OfferBean> offer;
	
	@OneToMany(mappedBy= "eventOrganizer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BookingEvent> booking;
	
	@OneToMany(mappedBy= "eventOrganizer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ComplaintBean> complaint;

	private Boolean validate;
	@Column(length = 30)
	private String verificationStatus;
	
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Boolean getValidate() {
		return validate;
	}
	public void setValidate(Boolean validate) {
		this.validate = validate;
	}
	public String getVerificationStatus() {
		return verificationStatus;
	}
	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}
	public int getLoginAttempt() {
		return loginAttempt;
	}
	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public List<EventBean> getEventBeans() {
		return eventBeans;
	}
	public void setEventBeans(List<EventBean> eventBeans) {
		this.eventBeans = eventBeans;
	}
	public List<ComplaintBean> getComplaintBeans() {
		return complaintBeans;
	}
	public void setComplaintBeans(List<ComplaintBean> complaintBeans) {
		this.complaintBeans = complaintBeans;
	}
	public List<AdminBean> getCategory() {
		return category;
	}
	public void setCategory(List<AdminBean> category) {
		this.category = category;
	}
	public List<OfferBean> getOffer() {
		return offer;
	}
	public void setOffer(List<OfferBean> offer) {
		this.offer = offer;
	}
	public List<BookingEvent> getBooking() {
		return booking;
	}
	public void setBooking(List<BookingEvent> booking) {
		this.booking = booking;
	}
	public List<ComplaintBean> getComplaint() {
		return complaint;
	}
	public void setComplaint(List<ComplaintBean> complaint) {
		this.complaint = complaint;
	}
	@Override
	public String toString() {
		return "RegistrationBean [registrationId=" + registrationId + ", username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", address="
				+ address + ", contactNumber=" + contactNumber + ", role=" + role + ", loginAttempt=" + loginAttempt
				+ ", complaintBeans=" + complaintBeans + ", eventBeans=" + eventBeans + ", category=" + category
				+ ", offer=" + offer + ", booking=" + booking + ", complaint=" + complaint + ", validate=" + validate
				+ ", verificationStatus=" + verificationStatus + "]";
	}
	
}