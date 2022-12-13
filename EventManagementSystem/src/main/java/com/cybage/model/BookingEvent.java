package com.cybage.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Entity
@Table(name="booking_event",uniqueConstraints = {@UniqueConstraint(columnNames = "bookingId")})
public class BookingEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookingId")
	private int bookingId;
	
	@Column(name="bookingStatus")
	private String bookingStatus = "PENDING";
	
	@Column(name="userBookingStatus")
	private String userBookingStatus = "CONFIRMED";
	
	@ManyToOne
	@JoinColumn(name="eventId")
	public EventBean event;
	
	@ManyToOne
	@JoinColumn(name="userId")
	public RegistrationBean user;
	
	@ManyToOne
	@JoinColumn(name="offerId")
	public OfferBean offer;

	@ManyToOne
	@JoinColumn(name="eventOrganizerId")
	public RegistrationBean eventOrganizer;
	
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public EventBean getEvent() {
		return event;
	}

	public void setEvent(EventBean event) {
		this.event = event;
	}

	public RegistrationBean getUser() {
		return user;
	}

	public void setUser(RegistrationBean user) {
		this.user = user;
	}

	public OfferBean getOffer() {
		return offer;
	}

	public void setOffer(OfferBean offer) {
		this.offer = offer;
	}

	public String getUserBookingStatus() {
		return userBookingStatus;
	}

	public void setUserBookingStatus(String userBookingStatus) {
		this.userBookingStatus = userBookingStatus;
	}

	public RegistrationBean getEventOrganizer() {
		return eventOrganizer;
	}

	public void setEventOrganizer(RegistrationBean eventOrganizer) {
		this.eventOrganizer = eventOrganizer;
	}
	
	
	
}