package com.cybage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="offer_table", uniqueConstraints = {@UniqueConstraint(columnNames = "offerId")})
public class OfferBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="offerId", unique = true, nullable = false)
	private int offerId;
	
	@Column(name="offerName")
	private String offerName;
	
	@OneToMany(mappedBy= "offer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BookingEvent> bookingBean;
	
	@ManyToOne
	@JoinColumn(name="eventOrganizerId")
	private RegistrationBean eventOrganizer;

	public OfferBean() {
		
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public List<BookingEvent> getBookingBean() {
		return bookingBean;
	}

	public void setBookingBean(List<BookingEvent> bookingBean) {
		this.bookingBean = bookingBean;
	}

	public RegistrationBean getEventOrganizer() {
		return eventOrganizer;
	}

	public void setEventOrganizer(RegistrationBean eventOrganizer) {
		this.eventOrganizer = eventOrganizer;
	}
	
	
	
}