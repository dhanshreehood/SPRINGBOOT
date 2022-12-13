package com.cybage.model;

import java.util.Date;
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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@NoArgsConstructor
//@Getter
//@Setter
//@ToString

@Entity
@Table(name="Event",uniqueConstraints = {@UniqueConstraint(columnNames = "eventId")})

public class EventBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eventId", unique = true, nullable = false)
	private int eventId;
	
	@Column(name="eventName")
	private String eventName;
	
	@Column(name="eventDate")
	private Date eventDate;
	
	@Column(name="eventDescription")
	private String eventDescription;
	
	@Column(name="eventLocation")
	private String eventLocation;
	
	@Column(name="eventPrice")
	private int eventPrice;
	
	@ManyToOne
	@JoinColumn(name="eventCategoryId")
	private AdminBean eventCategory;
	
	@ManyToOne
	@JoinColumn(name="eventOrganizerId")
	private RegistrationBean eventOrganizer;
	
	@OneToMany(mappedBy= "eventNameId", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<ComplaintBean> complaintBeans;

	//category
	public AdminBean getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(AdminBean eventCategory) {
		this.eventCategory = eventCategory;
	}

	// events
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public int getEventPrice() {
		return eventPrice;
	}

	public void setEventPrice(int eventPrice) {
		this.eventPrice = eventPrice;
	}

	public RegistrationBean getEventOrganizer() {
		return eventOrganizer;
	}

	public void setEventOrganizer(RegistrationBean eventOrganizer) {
		this.eventOrganizer = eventOrganizer;
	}

	public List<ComplaintBean> getComplaintBeans() {
		return complaintBeans;
	}

	public void setComplaintBeans(List<ComplaintBean> complaintBeans) {
		this.complaintBeans = complaintBeans;
	}

}
